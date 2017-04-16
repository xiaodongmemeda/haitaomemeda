package test.bwie.com.q0415_am.utils;

import com.google.gson.Gson;

/**
 * Created by ${仇海涛} on 2017/4/15.
 * 类的用途 ：
 */

public class GsonUtil {
    public static <T>T getBean(String json,Class<T> cla){
        T t = null;
        Gson gson = new Gson();
        t = gson.fromJson(json,cla);
        return  t;
    }
}
