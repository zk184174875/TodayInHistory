package com.zk.todayinhistory.Base.mvp;

/**
 * Created by zk on 2017/6/27.
 */

public interface BaseView {
    void onRequestStart();

    void onRequestError(String msg);

    void onRequestEnd();

    void onInternetError();
}
