package com.bw.yq.gggg.activity.cc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.yq.R;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Main3Activity extends AppCompatActivity {
    private String url="http://172.17.8.100/small/user/v1/register";
    private Button zhuce1;
    private EditText name;
    private EditText pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        zhuce1 = findViewById(R.id.zhuce1);
        name = findViewById(R.id.name1);
        pass1 = findViewById(R.id.pass1);
        zhuce1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name1 = name.getText().toString().trim();
                String pass =pass1.getText().toString().trim();
                if (name1.matches("^((1[83][0-9])|(14[57])|(17[035678])|(15[012356789])|(166)|(19[89]))\\d{8}$")&&pass.length()>6){

                    OkHttpClient okHttpClient=new OkHttpClient();
                    RequestBody requestBody=new FormBody.Builder()
                            .add("phone",name1)
                            .add("pwd",pass)
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

                        }
                    });


                }else{
                    Toast.makeText(Main3Activity.this, "手机号码或密码错误", Toast.LENGTH_SHORT).show();
                }

            }
        });
            }



    }

