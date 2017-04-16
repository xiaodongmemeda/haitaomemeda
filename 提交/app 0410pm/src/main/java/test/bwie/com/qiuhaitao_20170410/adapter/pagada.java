package test.bwie.com.qiuhaitao_20170410.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class pagada extends FragmentPagerAdapter {
    List<Fragment> list;
    List<String> lists;

    public pagada(FragmentManager fm, List<Fragment> list, List<String> lists) {
        super(fm);
        this.list = list;
        this.lists = lists;
    }

    public pagada(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return lists.get(position);
    }
}
