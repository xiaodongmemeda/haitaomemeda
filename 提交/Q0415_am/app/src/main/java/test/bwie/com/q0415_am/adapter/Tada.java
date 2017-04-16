package test.bwie.com.q0415_am.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import test.bwie.com.q0415_am.R;
import test.bwie.com.q0415_am.bean.Tbean;

/**
 * Created by ${仇海涛} on 2017/4/15.
 * 类的用途 ：
 */

public class Tada extends BaseAdapter {
    Context context;
    List<Tbean.DataBean> list;

    public Tada(Context context, List<Tbean.DataBean> list) {
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
        T_Holder holder = null;
        if (view==null){
            holder = new T_Holder();
            view = View.inflate(context, R.layout.t_item,null);
            holder.textView = (TextView) view.findViewById(R.id.t_item_text);
            view.setTag(holder);
        }else {
            holder = (T_Holder) view.getTag();
        }
        holder.textView.setText(list.get(i).getName());
        return view;
    }
    class T_Holder{
        TextView textView;
    }
}
