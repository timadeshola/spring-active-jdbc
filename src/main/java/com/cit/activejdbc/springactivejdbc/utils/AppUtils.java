package com.cit.activejdbc.springactivejdbc.utils;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by timad on 5/2/2019.
 */
public class AppUtils {

    public static  <T> String toJSON(T t) {
        return new Gson().toJson(t);
    }

    public <T> T fromJSON(String data, Type type) {
        return new Gson().fromJson(data, type);
    }

    public static <T> T fromJSON(String data, Class<T> tClass) {
        return new Gson().fromJson(data, tClass);
    }
}
