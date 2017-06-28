package com.zk.todayinhistory.History;

import android.view.View;

import com.blankj.utilcode.util.LogUtils;
import com.zk.todayinhistory.Base.BaseMvpFragment;
import com.zk.todayinhistory.R;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryFragment extends BaseMvpFragment<HistoryEventContract.Presenter,
        HistoryEventContract.Module> {


    @Override
    public void onRequestStart() {
        LogUtils.e("开始加载");
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.e("加载错误:"+msg);
    }

    @Override
    public void onRequestEnd() {
        LogUtils.e("加载结束");
    }

    @Override
    public void onInternetError() {
        LogUtils.e("加载错误");
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void initLoad() {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.content_main;
    }
}
