package test.bwie.com.qiuhaitao_0407.Utils;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import test.bwie.com.qiuhaitao_0407.bean.Bean;

/**
 * Created by ${仇海涛} on 2017/4/7.
 * 类的用途 ：
 */

public class MyAsyncTask extends AsyncTask {



    @Override
    protected Object doInBackground(Object[] objects) {
        String json = doget((String) objects[0]);
//        Bean bean = GsonUtil.getBean(json, Bean.class);
        Gson gson = new Gson();
        Bean bean = gson.fromJson(json, Bean.class);
        return bean;
    }
    public String doget(String json){
        try {
            //通过URL得到httpurlconnection
            URL u = new URL(json);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(2000);
            if (connection.getResponseCode()==200){
                //通过httpurlconnection得到输入流 得到数据
                InputStream inputStream = connection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String s ="";
                StringBuilder builder = new StringBuilder();
                while ((s = bufferedReader.readLine())!=null){
                    builder.append(s);
                }
                String string = builder.toString();
                return  string;

            }
        }catch (Exception e){}
        return null;
    }
}
