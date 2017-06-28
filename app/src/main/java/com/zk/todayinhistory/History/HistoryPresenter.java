package com.zk.todayinhistory.History;

import com.blankj.utilcode.util.LogUtils;
import com.zk.todayinhistory.Bean.HistoryEventResult;

import java.util.Calendar;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryPresenter extends HistoryEventContract.Presenter {

    @Override
    public void getHistory(final Calendar calendar) {
        mModule.getHistory(calendar).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HistoryEventResult>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                            LogUtils.e("onSubscribe");
                    }

                    @Override
                    public void onNext(HistoryEventResult value) {
                        mView.getHistorySuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("出错" + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
//                .subscribe(new Consumer<HistoryEventResult>() {
//                    @Override
//                    public void accept(HistoryEventResult historyEventResult) throws
//                            Exception {
//                        mView.getHistorySuccess(historyEventResult);
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//                        mView.onInternetError();
//                   //     mView.onRequestError(throwable.getMessage());
//                        LogUtils.e("出错" + throwable.getMessage());
//                    }
//                });
    }
}