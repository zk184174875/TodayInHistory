package com.zk.todayinhistory.Base;

import android.app.Application;

import com.alibaba.fastjson.JSON;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.Utils;
import com.zk.todayinhistory.Bean.HistoryEvent;

/**
 * Created by zk on 2017/6/27.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
        HistoryEvent historyEvent = new HistoryEvent();
        historyEvent.setDay(19);
        historyEvent.setDes("描述");
        historyEvent.setId("id111");
        historyEvent.setMonth(2);
        historyEvent.setYear(1993);
        LogUtils.e(JSON.toJSONString(historyEvent));
        HistoryEvent historyEvent1 = JSON.parseObject(JSON.toJSONString(historyEvent),
                HistoryEvent.class);
        LogUtils.e(historyEvent1.getDes());
    }
}
