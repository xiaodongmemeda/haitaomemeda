package test.bwie.com.qiuhaitao_0407.Utils;

import com.google.gson.Gson;

/**
 * Created by ${仇海涛} on 2017/4/5.
 * 类的用途 ：解析工具类
 */

public class GsonUtil {
    //根据不同的bean类返回不同的数据
    public static <T>T getBean(String json,Class<T> cla){
        T t = null;
        Gson gson = new Gson();
        t = gson.fromJson(json, cla);
        return  t;
    }
}
