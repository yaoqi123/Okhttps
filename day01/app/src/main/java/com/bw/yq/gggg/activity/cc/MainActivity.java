package com.bw.yq.gggg.activity.cc;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.gggg.activity.bb.Data;
import com.bw.yq.gggg.activity.bb.Datas;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button deng;
    private Button zhu;
    private String url="http://172.17.8.100/small/user/v1/login";
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                   String path= (String) msg.obj;
                  Gson gson=new Gson();
                    Data data = gson.fromJson(path, Data.class);
                    String status = data.getStatus();
                    if (data.getStatus().equals("0000")){
                        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                        startActivity(intent);
                    }
                    ;

            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        deng = findViewById(R.id.deng);
        zhu = findViewById(R.id.zhu);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String names = name.getText().toString().trim();
                String pass1 = pass.getText().toString().trim();
                if (names.matches("^((1[83][0-9])|(14[57])|(17[035678])|(15[012356789])|(166)|(19[89]))\\d{8}$")&&pass1.length()>6){

                    OkHttpClient okHttpClient=new OkHttpClient();
                    RequestBody requestBody=new FormBody.Builder()
                            .add("phone","15721188633")
                            .add("pwd","123")
                            .build();
                    Request request=new Request.Builder().url(url).post(requestBody).build();
                    Call call = okHttpClient.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        public void onFailure(Call call, IOException e) {

                        }

                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                            String json = response.body().string();
                           // Log.i("xxx",json);
                            Message message = new Message();
                            message.what=0;
                            message.obj=json;
                            handler.sendMessage(message);

                        }
                    });


                }else{
                    Toast.makeText(MainActivity.this, "手机号码或密码错误", Toast.LENGTH_SHORT).show();
                }

            }
        });
        zhu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main3Activity.class);
                startActivity(intent);
            }
        });
    }
}
