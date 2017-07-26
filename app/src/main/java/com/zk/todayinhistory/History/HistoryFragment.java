package com.zk.todayinhistory.History;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blankj.utilcode.util.LogUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zk.todayinhistory.Base.BaseMvpFragment;
import com.zk.todayinhistory.Bean.HistoryEventResult;
import com.zk.todayinhistory.R;
import com.zk.todayinhistory.adapter.HistoryEventAdapter;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryFragment extends BaseMvpFragment<HistoryPresenter,
        HistoryModule> implements HistoryEventContract.View {

    HistoryEventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter.getHistory(Calendar.getInstance());
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onRequestStart() {
        LogUtils.e("开始加载");
    }

    @Override
    public void onRequestError(String msg) {
        LogUtils.e("加载错误:" + msg);
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
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview_history_event);
        LinearLayoutManager manager = new LinearLayoutManager(this.getContext());
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        adapter = new HistoryEventAdapter(R.layout.item_history_event, new
                ArrayList<HistoryEventResult.HistoryEvent>());
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);
        recyclerView.setAdapter(adapter);

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
        return R.layout.fragment_history_event;
    }

    @Override
    public void getHistorySuccess(HistoryEventResult historyEventResult) {

        adapter.clearAddAllNotifyDataSetChanged(historyEventResult.getResult());
    }
}
