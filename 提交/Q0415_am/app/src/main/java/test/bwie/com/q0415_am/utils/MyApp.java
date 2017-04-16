package test.bwie.com.q0415_am.utils;

import android.app.Application;

import org.xutils.x;

/**
 * Created by ${仇海涛} on 2017/4/15.
 * 类的用途 ：
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(false);
    }
}
