package test.bwie.com.qiuhaitao_0407.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import test.bwie.com.qiuhaitao_0407.R;
import test.bwie.com.qiuhaitao_0407.Utils.MyAsyncTask;
import test.bwie.com.qiuhaitao_0407.adapter.MainlistAda;
import test.bwie.com.qiuhaitao_0407.bean.Bean;
import test.bwie.com.qiuhaitao_0407.bean.U;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private MainlistAda ada;
    private List<Bean.ListBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            initView();
            initData();
        }

    private void initData() {

        MyAsyncTask asyncTask = new MyAsyncTask(MainActivity.this,listView);

        asyncTask.execute(U.u);



    }

    private void initView() {

        listView = (ListView) findViewById(R.id.main_listview_01);

    }

}

