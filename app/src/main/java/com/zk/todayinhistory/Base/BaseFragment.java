package com.zk.todayinhistory.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zk on 2017/6/27.
 */

public abstract class BaseFragment extends Fragment implements BaseFuncImpl{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(),container,false);
        initData();
        initListener();
        initLoad();
        initView(view);
        return view;
    }
    protected abstract int getContentViewId();

}
