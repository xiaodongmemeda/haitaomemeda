package test.bwie.com.qiuhaitao_20170410.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import test.bwie.com.qiuhaitao_20170410.R;
import test.bwie.com.qiuhaitao_20170410.Utils.GetJson;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class Frag_main extends Fragment{

    private ListView listView;

    public static Fragment getF(String url){
        Frag_main frag_main = new Frag_main();
        Bundle bundle = new Bundle();
        bundle.putString("u",url);
        frag_main.setArguments(bundle);
        return frag_main;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main,null);
        listView = (ListView) view.findViewById(R.id.frag_listview);
        Bundle bundle = getArguments();
        String u = bundle.getString("u");
        GetJson getJson = new GetJson(getActivity(),listView);
        getJson.getJson(u);
        return view;
    }
}
