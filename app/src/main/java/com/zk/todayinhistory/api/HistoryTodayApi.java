package com.zk.todayinhistory.api;

import com.zk.todayinhistory.Bean.HistoryEvent;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by zk on 2017/6/28.
 */

public interface HistoryTodayApi {
    @GET("/japi/toh")
    Observable<List<HistoryEvent>> getHistoryToday(@QueryMap Map<String,String> map);
}
