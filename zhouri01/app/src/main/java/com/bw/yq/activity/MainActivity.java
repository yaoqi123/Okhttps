package com.bw.yq.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.presenter.LoginPresenter;
import com.bw.yq.utils.Uitls;
import com.bw.yq.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText ed1;
    private EditText ed2;
    private Button deng;
    private Button zhu;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        deng = findViewById(R.id.deng);
        zhu = findViewById(R.id.zhu);
        presenter = new LoginPresenter(this);
        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = ed1.getText().toString().trim();
                String pass = ed2.getText().toString().trim();
                boolean mobileNO = Uitls.isMobileNO(name);
                if (!mobileNO){
                    Toast.makeText(MainActivity.this, "电话号码不正确", Toast.LENGTH_SHORT).show();

                }
                if(pass.length()<3){

                    Toast.makeText(MainActivity.this, "密码长度不能小于3", Toast.LENGTH_SHORT).show();
                }

                presenter.sendLogin(name,pass);
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

    @Override
    public void view(String status) {
        if (status.equals("0000")){
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }
}
