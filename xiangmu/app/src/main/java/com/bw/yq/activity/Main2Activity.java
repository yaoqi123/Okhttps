package com.bw.yq.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.presenter.RegisterPresenter;
import com.bw.yq.view.RegisterView;

public class Main2Activity extends AppCompatActivity implements RegisterView {

    private EditText name;
    private EditText pass;
    private RegisterPresenter presenter;
    private TextView tv1;
    private String name1;
    private String pass1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
             name = findViewById(R.id.name);
             pass = findViewById(R.id.pass);
             Button zc= findViewById(R.id.zc);
        tv1 = findViewById(R.id.tiao);
             presenter = new RegisterPresenter(this);
             zc.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     name1 = name.getText().toString().trim();
                     pass1 = pass.getText().toString().trim();
                   if (name1.equals("")&& pass1.equals("")){

                       Toast.makeText(Main2Activity.this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
                   }
                 presenter.sendRegister(name1, pass1);


                 }

             });
             tv1.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                     intent.putExtra("name",name1);
                     intent.putExtra("pass",pass1);
                     startActivityForResult(intent,1);
                 }
             });

    }

    @Override
    public void view(String message, String status) {
        if (status.equals("0000")){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }
}
