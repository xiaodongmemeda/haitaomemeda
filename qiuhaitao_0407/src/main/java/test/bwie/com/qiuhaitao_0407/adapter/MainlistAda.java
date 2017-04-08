package test.bwie.com.qiuhaitao_0407.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.qiuhaitao_0407.R;
import test.bwie.com.qiuhaitao_0407.bean.Bean;


/**
 * Created by ${仇海涛} on 2017/4/7.
 * 类的用途 ：
 */

public class MainlistAda extends BaseAdapter {
    Context context;
    List<Bean.ListBean> list;

    public MainlistAda(Context context, List<Bean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (view==null){
            holder = new Holder();
            view = View.inflate(context, R.layout.item,null);
            holder.textView1 = (TextView) view.findViewById(R.id.item_text_01);
            holder.textView2 = (TextView) view.findViewById(R.id.item_text_02);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();}
        holder.textView1.setText(list.get(i).getSite_name());
        holder.textView2.setText(list.get(i).getAddress());
        return view;
    }
    class Holder{
        TextView textView1;
        TextView textView2;
    }
}
