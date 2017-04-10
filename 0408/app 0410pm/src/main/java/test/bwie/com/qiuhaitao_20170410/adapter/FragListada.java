package test.bwie.com.qiuhaitao_20170410.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import test.bwie.com.qiuhaitao_20170410.R;
import test.bwie.com.qiuhaitao_20170410.bean.Bean;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class FragListada extends BaseAdapter{
    Context context;
    List<Bean.NewslistBean> list;

    public FragListada(Context context, List<Bean.NewslistBean> list) {
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
            holder.imageView = (ImageView) view.findViewById(R.id.item_img);
            holder.textView1 = (TextView) view.findViewById(R.id.item_text1);
            holder.textView2 = (TextView) view.findViewById(R.id.item_text2);
            view.setTag(holder);
        }else {
            holder = (Holder) view.getTag();
        }
       // ImageLoader.getInstance().displayImage(list.get(i).getPicUrl(),holder.imageView, ImageUtils.setImage(R.mipmap.ic_launcher));
        x.image().bind(holder.imageView,list.get(i).getPicUrl());
        holder.textView1.setText(list.get(i).getTitle());
        holder.textView2.setText(list.get(i).getDescription());
        return view;
    }
    class Holder{
        ImageView imageView;
        TextView textView1;
        TextView textView2;
    }
}
