package test.bwie.com.more_login.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;

import test.bwie.com.more_login.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button qq;
    private Button qq_web;
    private Button qq_file;
    private Button ff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        qq = (Button) findViewById(R.id.qq_img);

        qq.setOnClickListener(this);
        qq_web = (Button) findViewById(R.id.qq_web);
        qq_web.setOnClickListener(this);
        qq_file = (Button) findViewById(R.id.qq_file);
        qq_file.setOnClickListener(this);
        ff= (Button) findViewById(R.id.f);
        ff.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.qq_img:

                UMImage image = new UMImage(MainActivity.this, R.mipmap.ic_launcher);//资源文件
                new ShareAction(MainActivity.this).setPlatform(SHARE_MEDIA.QQ)
                        .withMedia(image)
                        .withText("hello")
                        .setCallback(umShareListener)
                        .share();
                break;
            case R.id.qq_web:
                break;
            case R.id.qq_file:
                break;
            case R.id.f:
                UMImage image1 = new UMImage(MainActivity.this, R.mipmap.ic_launcher);//资源文件
                new ShareAction(MainActivity.this).withMedia(image1)
                        .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                        .setCallback(umShareListener).open();
                break;
        }
    }

    private UMShareListener umShareListener = new UMShareListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            //分享开始的回调
        }

        @Override
        public void onResult(SHARE_MEDIA platform) {
            Log.d("plat", "platform" + platform);

            Toast.makeText(MainActivity.this, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(MainActivity.this, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
            if (t != null) {
                Log.d("throw", "throw:" + t.getMessage());
            }
        }

        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(MainActivity.this, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);

    }
}
