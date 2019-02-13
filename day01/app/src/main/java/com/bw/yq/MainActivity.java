package com.bw.yq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText pass;
    private Button deng;
    private Button zhu;
    private String url="http://120.27.23.105/user/login";

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
                OkHttpClient okHttpClient=new OkHttpClient();
                RequestBody requestBody=new FormBody.Builder()
                        .add("phone","18810609754")
                        .add("pwd","123")
                        .build();
                Request request=new Request.Builder().url()

            }
        });
    }
}
