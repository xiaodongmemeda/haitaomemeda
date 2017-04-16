package test.bwie.com.qiuhaitao_0407.Utils;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import test.bwie.com.qiuhaitao_0407.adapter.MainlistAda;
import test.bwie.com.qiuhaitao_0407.bean.Bean;

/**
 * Created by ${仇海涛} on 2017/4/7.
 * 类的用途 ：
 */

public class MyAsyncTask extends AsyncTask<String, Integer, List<Bean.ListBean>> {
    private ListView listView;
    private Context context;

    public MyAsyncTask(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    @Override
    protected void onPostExecute(final List<Bean.ListBean> listBeen) {
        super.onPostExecute(listBeen);
        final MainlistAda mainlistAda = new MainlistAda(context, listBeen);
        listView.setAdapter(mainlistAda);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(context, listBeen.get(i).getId() + "", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                listBeen.remove(i);
                mainlistAda.notifyDataSetChanged();
                return false;
            }
        });

    }

    public String doget(String json) {
        try {
            //通过URL得到httpurlconnection
            URL u = new URL(json);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(2000);
            if (connection.getResponseCode() == 200) {
                //通过httpurlconnection得到输入流 得到数据
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String s = "";
                StringBuilder builder = new StringBuilder();
                while ((s = bufferedReader.readLine()) != null) {
                    builder.append(s);
                }
                String string = builder.toString();
                return string;

            }
        } catch (Exception e) {
        }
        return null;
    }

    @Override
    protected List<Bean.ListBean> doInBackground(String... strings) {
        String json = doget(strings[0]);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(json, Bean.class);
        List<Bean.ListBean> list = bean.getList();
        return list;
    }
}
