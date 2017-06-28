package com.zk.todayinhistory.Base;

import android.view.View;

/**
 * Created by zk on 2017/6/28.
 */

public interface BaseFuncImpl {
    /**
     * 初始化控件
     */
    void initView(View view);

    /**
     * 初始化数据
     */
    void initData();

    /**
     * 初始化监听事件
     */
    void initListener();

    /**
     * 初始化界面加载
     */
    void initLoad();
}
