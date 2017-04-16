package test.bwie.com.q0415_am.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.q0415_am.R;
import test.bwie.com.q0415_am.bean.Qbean;

/**
 * Created by ${仇海涛} on 2017/4/15.
 * 类的用途 ：
 */

public class Listada extends BaseAdapter{
    List<Qbean.DataBean> list ;
    Context context;

    public Listada(Context context, List<Qbean.DataBean> list) {
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
        if (view == null){
            holder = new Holder();
            view = View.inflate(context, R.layout.item,null);
            holder.textView1 = (TextView) view.findViewById(R.id.text1);
            holder.textView2 = (TextView) view.findViewById(R.id.text2);
            holder.textView3 = (TextView) view.findViewById(R.id.text3);
            view.setTag(holder);
        }else{
            holder = (Holder) view.getTag();
        }
        holder.textView1.setText(list.get(i).getTitle());
        holder.textView2.setText(list.get(i).getApply());
        holder.textView3.setText(list.get(i).getBuy_price());
        return view;
    }
    class Holder{
        TextView textView1;
        TextView textView2;
        TextView textView3;
    }
}
