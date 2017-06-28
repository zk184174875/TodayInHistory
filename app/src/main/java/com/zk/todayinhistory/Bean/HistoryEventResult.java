package com.zk.todayinhistory.Bean;

import java.util.List;

/**
 * Created by zk on 2017/6/27.
 */

public class HistoryEventResult {

    private List<HistoryEvent> result;

    public List<HistoryEvent> getResult() {
        return result;
    }

    public void setResult(List<HistoryEvent> result) {
        this.result = result;
    }


    public static class HistoryEvent {

        private String id;
        private String title;
        private String pic;
        private int year;
        private int month;
        private int day;
        private String des;
        private String lunar;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }

        public String getLunar() {
            return lunar;
        }

        public void setLunar(String lunar) {
            this.lunar = lunar;
        }

    }
}
