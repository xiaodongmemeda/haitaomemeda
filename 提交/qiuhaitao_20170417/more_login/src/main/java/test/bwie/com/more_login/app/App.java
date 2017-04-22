package test.bwie.com.more_login.app;

import android.app.Application;

import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by ${仇海涛} on 2017/4/19.
 * 类的用途 ：
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();


        //PlatformConfig.setQQZone("1105602574","");
        UMShareAPI.get(this);
        Config.DEBUG=true;
    }
    //PlatformConfig.setWeixin("","");
    {
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    //PlatformConfig.setSinaWeibo("","","");
}
