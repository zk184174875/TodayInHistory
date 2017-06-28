package com.zk.todayinhistory.api;

import com.blankj.utilcode.util.LogUtils;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zk.todayinhistory.BuildConfig;
import com.zk.todayinhistory.global.Constants;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by zk on 2017/6/28.
 */

public class NetWorks {
    private static NetWorks netWorks;
    private Retrofit retrofit;
    private HistoryTodayApi historyTodayApi;

    private NetWorks() {
    }

    public static NetWorks getInstance() {
        if (netWorks == null) {
            synchronized (NetWorks.class) {
                if (netWorks == null)
                    netWorks = new NetWorks();
            }
        }
        return netWorks;
    }

    public HistoryTodayApi getHistoryTodayApi() {
        return historyTodayApi == null? configRetrofit(HistoryTodayApi.class):historyTodayApi;
    }

    private <T> T configRetrofit(Class<T> tClass) {
        return configRetrofit(tClass, Constants.HISTORY_TODAY_BASE_URL);
    }

    private <T> T configRetrofit(Class<T> tClass, String baseUrl) {
        String url = baseUrl == null ? Constants.BASE_URL : baseUrl;
        retrofit = new Retrofit.Builder().baseUrl(url).client
                (configOkHttpClient())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        return retrofit.create(tClass);
    }

    private OkHttpClient configOkHttpClient() {
        OkHttpClient.Builder okHttpBuild = new OkHttpClient.Builder();

        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request.Builder builder1 = chain.request().newBuilder();
                Request request = builder1.build();
                return chain.proceed(request);
            }
        };
        if (BuildConfig.DEBUG){
            Interceptor logInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Response response = chain.proceed(request);
                    ResponseBody responseBody = response.body();
                    BufferedSource bufferedSource = responseBody.source();
                    bufferedSource.request(Long.MAX_VALUE);
                    Buffer buffer = bufferedSource.buffer();
                    Charset utf8 = Charset.forName("UTF-8");
                    LogUtils.i("REQUEST"+request.toString());
                    LogUtils.i("RESPONSE"+buffer.clone().readString(utf8));
                    return response;
                }
            };
            okHttpBuild.addInterceptor(logInterceptor);
        }
        okHttpBuild.addNetworkInterceptor(interceptor);
        okHttpBuild.connectTimeout(20, TimeUnit.SECONDS);

        return okHttpBuild.build();
    }

}
