package com.bw.yq.gggg.activity.cc;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.gggg.activity.bean.User;
import com.bw.yq.gggg.activity.bean.Users;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main2Activity extends AppCompatActivity {

    private PullToRefreshListView pull;
private String url="http://www.xieast.com/api/news/news.php?page=1";
private Handler handler=new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what){
            case 0:
           String path= (String) msg.obj;
                Gson gson=new Gson();
                User user = gson.fromJson(path, User.class);
                ArrayList<Users> data = user.getData();
                Toast.makeText(Main2Activity.this, data.toString(), Toast.LENGTH_SHORT).show();

                break;

        }
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pull = findViewById(R.id.pull);
        initData();
    }

    private void initData() {
        //实例化
        OkHttpClient okHttpClient=new OkHttpClient();
        //创建request请求方式
        Request request=new Request.Builder().url(url).build();
        //执行请求
        Call call = okHttpClient.newCall(request);
        //执行异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("xxx",string);
                Message message = new Message();
                message.what=0;
                message.obj=string;
                handler.sendMessage(message);
            }
        });

    }
}
