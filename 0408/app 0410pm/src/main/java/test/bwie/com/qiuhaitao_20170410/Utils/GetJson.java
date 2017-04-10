package test.bwie.com.qiuhaitao_20170410.Utils;

import android.content.Context;
import android.widget.ListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.List;

import test.bwie.com.qiuhaitao_20170410.adapter.FragListada;
import test.bwie.com.qiuhaitao_20170410.bean.Bean;

/**
 * Created by ${仇海涛} on 2017/4/10.
 * 类的用途 ：
 */

public class GetJson{
    Context context;
    ListView listView ;

    public GetJson(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    public void getJson(String url){

        RequestParams params = new RequestParams(url);
        //params.addQueryStringParameter("uri","yl");


        x.http().get(params, new Callback.CommonCallback<String>() {


            @Override
            public void onSuccess(String result) {
                Bean bean = GsonUtils.getBean(result, Bean.class);
                List<Bean.NewslistBean> newslist = bean.getNewslist();
                FragListada fragListada = new FragListada(context,newslist);
                listView.setAdapter(fragListada);
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
     /*  try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(2000);
            connection.setConnectTimeout(2000);
            if (connection.getResponseCode() == 200){
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String s = null;
                StringBuilder builder = new StringBuilder();
                while((s=bufferedReader.readLine())!=null){
                    builder.append(s);
                }
                Message message =  Message.obtain();
                message.what = 1;
                message.obj = builder.toString();
                handler.sendMessage(message);

            }
        }catch (Exception e){}*/
    }

}
