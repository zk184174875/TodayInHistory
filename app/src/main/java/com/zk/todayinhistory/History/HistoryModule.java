package com.zk.todayinhistory.History;

import com.zk.todayinhistory.Bean.HistoryEventResult;
import com.zk.todayinhistory.api.NetWorks;
import com.zk.todayinhistory.global.Constants;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryModule implements HistoryEventContract.Module {
    @Override
    public Observable<HistoryEventResult> getHistory(Calendar calendar) {
        Map<String, String> map = new HashMap<>();
        map.put("key", Constants.HISTORY_TODAY_APP_KEY);
        map.put("v", "1.0");
        map.put("month", calendar.get(Calendar.MONTH) + "");
        map.put("day", calendar.get(Calendar.DAY_OF_MONTH) + "");
        return NetWorks.getInstance().getHistoryTodayApi().getHistoryToday(map);
    }
}
