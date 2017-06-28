package com.zk.todayinhistory.History;

import com.blankj.utilcode.util.LogUtils;
import com.zk.todayinhistory.Bean.HistoryEvent;

import java.util.Calendar;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryPresenter extends HistoryEventContract.Presenter {

    @Override
    public void getHistory(final Calendar calendar) {
        mModule.getHistory(calendar).subscribeOn(Schedulers.io())
                .doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(Disposable disposable) throws Exception {
                        mView.onRequestStart();
                    }
                })
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<HistoryEvent>>() {
                    @Override
                    public void accept(List<HistoryEvent> historyEventList) throws Exception {
                        mView.getHistorySuccess(historyEventList);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        mView.onInternetError();
                        mView.onRequestError(throwable.getMessage());
                        LogUtils.e("出错" + throwable.getMessage());
                    }
                });
    }
}