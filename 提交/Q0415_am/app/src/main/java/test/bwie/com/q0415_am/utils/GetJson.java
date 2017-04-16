package test.bwie.com.q0415_am.utils;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

import test.bwie.com.q0415_am.R;
import test.bwie.com.q0415_am.adapter.Listada;
import test.bwie.com.q0415_am.adapter.Tada;
import test.bwie.com.q0415_am.bean.Qbean;
import test.bwie.com.q0415_am.bean.Tbean;
import test.bwie.com.q0415_am.bean.U;
import test.bwie.com.q0415_am.fragment.Frag;

/**
 * Created by ${仇海涛} on 2017/4/15.
 * 类的用途 ：
 */

public class GetJson {
    private Context context;
    private ListView listView;
    private  TextView textView;
    private FragmentManager manager;


    public GetJson(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    public GetJson(Context context, ListView listView, FragmentManager manager, TextView textView) {
        this.context = context;
        this.listView = listView;
        this.manager = manager;
        this.textView = textView;
    }

    public  void getTjson(String turi){
        final ArrayList<String> list = new ArrayList<>();
        list.add(U.u1);
        list.add(U.u2);
        list.add(U.u3);
        RequestParams params = new RequestParams(turi);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Tbean bean = GsonUtil.getBean(result, Tbean.class);
                final List<Tbean.DataBean> data = bean.getData();
                Tada tada = new Tada(context,data);
                listView.setAdapter(tada);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        textView.setText(data.get(i).getName());
                        Frag frag = new Frag();
                        frag.Json = list.get(i);
                        manager.beginTransaction().replace(R.id.rela_f,frag).commit();
                    }
                });
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }

    public  void getJson(String uri ){
        RequestParams params = new RequestParams(uri);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Qbean bean = GsonUtil.getBean(result, Qbean.class);
                List<Qbean.DataBean> data = bean.getData();
                Listada listada = new Listada(context,data);
                listView.setAdapter(listada);

            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }
}
