package test.bwie.com.qiuhaitao_20170410.activity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.qiuhaitao_20170410.Fragment.Frag_main;
import test.bwie.com.qiuhaitao_20170410.R;
import test.bwie.com.qiuhaitao_20170410.U.U;
import test.bwie.com.qiuhaitao_20170410.adapter.pagada;

public class MainActivity extends FragmentActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("s",MODE_PRIVATE);

        initview();
        initdata();
    }

    private void initdata() {
        List<Fragment> list = new ArrayList<>();
        list.add(Frag_main.getF(U.shehuiu));
        list.add(Frag_main.getF(U.guoneiu));
        list.add(Frag_main.getF(U.guojiu));
        list.add(Frag_main.getF(U.yuleu));
        list.add(Frag_main.getF(U.tiyuu));
        list.add(Frag_main.getF(U.nbau));
        list.add(Frag_main.getF(U.zuqiuu));
        list.add(Frag_main.getF(U.kejiu));
        list.add(Frag_main.getF(U.chuangyeu));
        list.add(Frag_main.getF(U.pinguou));
        List<String> lists = new ArrayList<>();
        lists.add("社会");
        lists.add("国内");
        lists.add("国际");
        lists.add("娱乐");
        lists.add("体育");
        lists.add("NBA");
        lists.add("足球");
        lists.add("科技");
        lists.add("创业");
        lists.add("苹果");
        pagada p = new pagada(getSupportFragmentManager(),list,lists);

        tabLayout.setTabsFromPagerAdapter(p);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setSelectedTabIndicatorColor(Color.RED);
        tabLayout.setTabTextColors(Color.BLACK,Color.RED);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setAdapter(p);
    }

    private void initview() {
        tabLayout = (TabLayout) findViewById(R.id.main_tablayout);
        viewPager = (ViewPager) findViewById(R.id.main_viewpager);
    }
}
