package test.bwie.com.qiuhaitao_20170417;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.tencent.connect.UserInfo;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import org.json.JSONException;
import org.json.JSONObject;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static final String APP_ID = "1105602574";//官方获取的APPID
    private Tencent mTencent;
    private BaseUiListener mIUiListener;
    private UserInfo mUserInfo;
    private TextView textView;
    private CircleImageView imageView;
    private Button qzone_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTencent =  Tencent.createInstance(APP_ID, this.getApplicationContext());
        slidingM();
    }

    private void slidingM() {
        SlidingMenu menu = new SlidingMenu(this);

        menu.setMode(SlidingMenu.LEFT);

        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);

        menu.setShadowWidth(R.dimen.shadow_height);

        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);

        menu.setFadeDegree(0.35f);

        menu.attachToActivity(this,SlidingMenu.SLIDING_CONTENT);

        View view = View.inflate(this,R.layout.sliding_view,null);

        menu.setMenu(view);

        imageView = (CircleImageView) menu.findViewById(R.id.img_qq);
        textView = (TextView) menu.findViewById(R.id.text_qq);
        qzone_btn = (Button) menu.findViewById(R.id.QZone);

        qzone_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle params = new Bundle();
                params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
                params.putString(QQShare.SHARE_TO_QQ_TITLE, "Hi,叶应是叶");
                params.putString(QQShare.SHARE_TO_QQ_SUMMARY, "欢迎访问我的博客");
                params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, "http://www.jianshu.com/p/7100645fe1a8");
                params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL, "http://avatar.csdn.net/B/0/1/1_new_one_object.jpg");
                params.putString(QQShare.SHARE_TO_QQ_APP_NAME, "HiTips");
                params.putInt(QQShare.SHARE_TO_QQ_EXT_INT, QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);
                mTencent.shareToQQ(MainActivity.this, params, mIUiListener);
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIUiListener = new BaseUiListener();
                //all表示获取所有权限
                mTencent.login(MainActivity.this,"all", mIUiListener);
            }
        });

    }

   /* public void LoginQQ() {
        //这里的APP_ID请换成你应用申请的APP_ID，我这里使用的是DEMO中官方提供的测试APP_ID 222222
        mAppid = AppConstant.APP_ID;
        //第一个参数就是上面所说的申请的APPID，第二个是全局的Context上下文，这句话实现了调用QQ登录
        mTencent = Tencent.createInstance(mAppid,getApplicationContext());
        *//**通过这句代码，SDK实现了QQ的登录，这个方法有三个参数，第一个参数是context上下文，第二个参数SCOPO 是一个String类型的字符串，表示一些权限
     官方文档中的说明：应用需要获得哪些API的权限，由“，”分隔。例如：SCOPE = “get_user_info,add_t”；所有权限用“all”
     第三个参数，是一个事件监听器，IUiListener接口的实例，这里用的是该接口的实现类 *//*
        mTencent.login(MainActivity.this,"all", new BaseUiListener());

    }*/
       // private  class IWXAPIEventHandler_wx implements IWXAPIEventHandler{}
    private class BaseUiListener implements IUiListener {

        @Override
        public void onComplete(Object response) {
            Toast.makeText(MainActivity.this, "授权成功", Toast.LENGTH_SHORT).show();
            Log.e(TAG, "response:" + response);
            JSONObject obj = (JSONObject) response;
            try {
                String openID = obj.getString("openid");
                String accessToken = obj.getString("access_token");
                String expires = obj.getString("expires_in");
                mTencent.setOpenId(openID);
                mTencent.setAccessToken(accessToken,expires);
                QQToken qqToken = mTencent.getQQToken();
                Context applicationContext = getApplicationContext();
                mUserInfo = new UserInfo(getApplicationContext(),qqToken);
                mUserInfo.getUserInfo(new IUiListener() {
                    @Override
                    public void onComplete(Object response) {
                        Log.e(TAG,"登录成功"+response.toString());
                        JSONObject res= (JSONObject) response;
                        String nickName=res.optString("nickname");//获取昵称
                        String figureurl_qq_1=res.optString("figureurl_qq_1");//获取图片
                        Log.d("mmm",nickName+"===="+figureurl_qq_1);
                        Glide.with(MainActivity.this).load(figureurl_qq_1).error(R.mipmap.ic_launcher).into(imageView);
                        textView.setText(nickName);

                    }

                    @Override
                    public void onError(UiError uiError) {
                        Log.e(TAG,"登录失败"+uiError.toString());
                    }

                    @Override
                    public void onCancel() {
                        Log.e(TAG,"登录取消");

                    }
                });
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(MainActivity.this, "授权失败", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onCancel() {
            Toast.makeText(MainActivity.this, "授权取消", Toast.LENGTH_SHORT).show();

        }

    }

    /**
     * 在调用Login的Activity或者Fragment中重写onActivityResult方法
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == Constants.REQUEST_LOGIN){
            Tencent.onActivityResultData(requestCode,resultCode,data,mIUiListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
