package com.zk.todayinhistory.History;

import com.zk.todayinhistory.Bean.HistoryEvent;

import java.util.Date;

import io.reactivex.Observable;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryModule implements HistoryEventContract.Module{
    @Override
    public Observable<HistoryEvent> getHistory(Date date) {
        return null;
    }
}
