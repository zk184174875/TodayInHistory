package com.zk.todayinhistory.utils;

import com.blankj.utilcode.util.LogUtils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by zk on 2017/6/27.
 */

public class TUtils {
    /**
     * 返回泛型参数对应的class
     *
     * @param o
     * @param i
     * @param <T>
     * @return
     */
    public static <T> T getT(Object o, int i) {
        try {
            Type type = o.getClass().getGenericSuperclass();
            Type trueType = ((ParameterizedType) type).getActualTypeArguments()[i];
            return ((Class<T>) trueType).newInstance();
        } catch (IllegalAccessException e) {
            LogUtils.e(e.getMessage());
        } catch (InstantiationException e) {
            LogUtils.e(e.getMessage());
        }
        return null;
    }

    public static Class<?> forName(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            LogUtils.e(e.getMessage());
        }
        return null;
    }
}
