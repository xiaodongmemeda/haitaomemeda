package test.bwie.com.qiuhaitao_20170410.Utils;

import com.google.gson.Gson;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class GsonUtils {
    public static <T>T getBean(String json,Class<T> cla){
        T t = null;
        Gson gson = new Gson();
        t = gson.fromJson(json,cla);
        return  t;
    }
}
