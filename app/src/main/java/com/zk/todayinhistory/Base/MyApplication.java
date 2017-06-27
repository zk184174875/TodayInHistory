package com.zk.todayinhistory.Base;

import android.app.Application;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;

/**
 * Created by zk on 2017/6/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        LogUtils.Builder builder = new LogUtils.Builder();
        builder.setLogSwitch(false);
        LogUtils.e("111111111111111");
    }
}
