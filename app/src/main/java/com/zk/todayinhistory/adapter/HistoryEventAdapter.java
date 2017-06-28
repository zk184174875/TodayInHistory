package com.zk.todayinhistory.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zk.todayinhistory.Bean.HistoryEventResult;
import com.zk.todayinhistory.R;

import java.util.List;

/**
 * Created by zk on 2017/6/28.
 */

public class HistoryEventAdapter extends BaseQuickAdapter<HistoryEventResult.HistoryEvent, BaseViewHolder> {
    private List<HistoryEventResult.HistoryEvent> data;

    public HistoryEventAdapter(@LayoutRes int layoutResId, @Nullable List<HistoryEventResult.HistoryEvent>
            data) {
        super(layoutResId, data);
        this.data = data;
    }

    @Override
    protected void convert(BaseViewHolder helper, HistoryEventResult.HistoryEvent item) {
        helper.setText(R.id.tv_title, item.getTitle());
        helper.setText(R.id.tv_lunar_time, item.getLunar());
        ImageView imageView = (ImageView) helper.getConvertView().findViewById(R.id.img);
        Glide.with(Utils.getContext()).load(TextUtils.isEmpty(item.getPic()) ? R.mipmap
                .ic_launcher : item.getPic()).into(imageView);
    }

    public void clearAddAllNotifyDataSetChanged(List<HistoryEventResult.HistoryEvent> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }
}
