package test.bwie.com.q0415_am.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

import test.bwie.com.q0415_am.R;
import test.bwie.com.q0415_am.bean.U;
import test.bwie.com.q0415_am.utils.GetJson;

public class MainActivity extends AppCompatActivity {

    private ImageView category;
    private RelativeLayout rela_f;
    private TextView all_yao;
    private TextView zhong_yao;
    private TextView xi_yao;
    private SlidingMenu menu;
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sliding();
    }

    private void sliding() {
        menu = new SlidingMenu(this);
        menu.setMode(SlidingMenu.LEFT);
        // 设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);

        // 设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        // 设置渐入渐出效果的值
        menu.setFadeDegree(0.35f);
        /**
         * SLIDING_WINDOW will include the Title/ActionBar in the content
         * section of the SlidingMenu, while SLIDING_CONTENT does not.
         */
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        //为侧滑菜单设置布局

        View view = View.inflate(this, R.layout.sliding_view, null);
        menu.setMenu(R.layout.sliding_view);

        listView = (ListView) menu.findViewById(R.id.tlistview);
        GetJson getJson = new GetJson(MainActivity.this, listView, getSupportFragmentManager(), textView);
        getJson.getTjson(U.ut);
    }

    /*private void initedate() {
        GetJson getJson = new GetJson(MainActivity.this,listView,getSupportFragmentManager(),textView);

    }*/

    private void initView() {
        View view = View.inflate(this, R.layout.sliding_view, null);
        textView = (TextView) findViewById(R.id.main_text);
        rela_f = (RelativeLayout) findViewById(R.id.rela_f);
        category = (ImageView) findViewById(R.id.category);
        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.toggle();
            }
        });
    }


}
