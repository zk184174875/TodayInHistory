package com.zk.todayinhistory.Base.mvp;

/**
 * Created by zk on 2017/6/27.
 */

public abstract class BasePresenter<M, V> {
    protected M mModule;
    protected V mView;

    public void setMV(M mModule, V mView) {
        this.mModule = mModule;
        this.mView = mView;
    }

}
