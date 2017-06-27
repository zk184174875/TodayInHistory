package com.zk.todayinhistory.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.zk.todayinhistory.Base.mvp.BaseModule;
import com.zk.todayinhistory.Base.mvp.BasePresenter;
import com.zk.todayinhistory.Base.mvp.BaseView;
import com.zk.todayinhistory.utils.TUtils;

/**
 * Created by zk on 2017/6/27.
 */

public abstract class BaseMvpFragment<P extends BasePresenter, M extends BaseModule> extends BaseFragment
        implements BaseView {
    protected P mPresenter;
    protected M mModule;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = TUtils.getT(this, 0);
        mModule = TUtils.getT(this, 1);
        mPresenter.setMV(mModule, this);
    }
}
