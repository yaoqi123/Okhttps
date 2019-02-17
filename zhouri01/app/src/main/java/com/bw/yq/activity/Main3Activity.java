package com.bw.yq.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.presenter.RegisterPresenter;
import com.bw.yq.view.RegisterView;

public class Main3Activity extends AppCompatActivity implements RegisterView {

    private EditText name;
    private EditText pass;
    private RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
    Button zhuce= findViewById(R.id.zhuce);
        registerPresenter = new RegisterPresenter(this);
    zhuce.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name1 = name.getText().toString().trim();
            String pass1 = pass.getText().toString().trim();
            if (name.equals("")&&pass.equals("")){

                Toast.makeText(Main3Activity.this, "电话号码密码不能为空", Toast.LENGTH_SHORT).show();
            }
           registerPresenter.sendRegister(name1,pass1);
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
