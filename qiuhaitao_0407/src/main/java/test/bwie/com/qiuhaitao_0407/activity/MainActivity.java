package test.bwie.com.qiuhaitao_0407.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        MyAsyncTask asyncTask = new MyAsyncTask(){
            @Override
            protected void onPostExecute(Object o) {
                super.onPostExecute(o);
                //Gson gson = new Gson();
                //Bean bean = gson.fromJson((String) o, Bean.class);
                //Bean bean = GsonUtil.getBean((String) o, Bean.class);
                Bean bean = (Bean) o;
                list = bean.getList();
                ada = new MainlistAda(MainActivity.this, list);
                listView.setAdapter(ada);
            }
        };

        asyncTask.execute(U.u);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, list.get(i).getId()+"", Toast.LENGTH_SHORT).show();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                list.remove(i);
                ada.notifyDataSetChanged();
                return false;
            }
        });

    }

    private void initView() {

        listView = (ListView) findViewById(R.id.main_listview_01);

    }

}

