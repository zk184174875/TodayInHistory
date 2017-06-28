package com.zk.todayinhistory.History;

import com.zk.todayinhistory.Base.mvp.BaseModule;
import com.zk.todayinhistory.Base.mvp.BasePresenter;
import com.zk.todayinhistory.Base.mvp.BaseView;
import com.zk.todayinhistory.Bean.HistoryEvent;

import java.util.Calendar;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by zk on 2017/6/27.
 */

public interface HistoryEventContract {
    interface Module extends BaseModule {
        Observable<List<HistoryEvent>> getHistory(Calendar calendar);
    }

    interface View extends BaseView {
        void getHistorySuccess(List<HistoryEvent> historyEventList);
    }

    abstract class Presenter extends BasePresenter<Module, View> {
        public abstract void getHistory(Calendar calendar);
    }
}
