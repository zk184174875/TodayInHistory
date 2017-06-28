package com.zk.todayinhistory.api;

import com.zk.todayinhistory.Bean.HistoryEventResult;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by zk on 2017/6/28.
 */

public interface HistoryTodayApi {
    @GET("/japi/toh")
    Observable<HistoryEventResult> getHistoryToday(@QueryMap Map<String,String> map);
}
