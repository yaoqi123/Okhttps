package com.bw.yq.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bw.yq.R;
import com.bw.yq.presenter.LoginPresenter;
import com.bw.yq.utils.Uitls;
import com.bw.yq.view.LoginView;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText username;
    private EditText userpass;
    private CheckBox jizhu;
    private TextView zhuce;
    private Button deng;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        userpass = findViewById(R.id.userpass);
        jizhu = findViewById(R.id.jizhu);
        zhuce = findViewById(R.id.zhuce);
        deng = findViewById(R.id.deng);
        sp = getSharedPreferences("jizhu", Context.MODE_PRIVATE);
        boolean fa = sp.getBoolean("第一次", false);
        if (fa) {

            username.setText(sp.getString("name", ""));
            userpass.setText(sp.getString("pass", ""));
            jizhu.setChecked(fa);

        }
        final LoginPresenter presenter = new LoginPresenter(this);

        deng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString().trim();
                String pass = userpass.getText().toString().trim();
                boolean mobileNO = Uitls.isMobileNO(name);
                if (!mobileNO) {
                    Toast.makeText(MainActivity.this, "电话号码不正确", Toast.LENGTH_SHORT).show();
                    return;

                }
                if (pass.length() < 3) {
                    Toast.makeText(MainActivity.this, "密码长度不能小于三", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.sendShow(name, pass);
                SharedPreferences.Editor edit = sp.edit();
                edit.putBoolean("第一次", jizhu.isChecked());
                edit.putString("name", name);
                edit.putString("pass", pass);
                edit.commit();
            }
        });
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public void view(String status) {
        if (status.equals("0000")) {
            Intent intent = new Intent(MainActivity.this, Main3Activity.class);

            startActivity(intent);
            finish();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String name = data.getStringExtra("name");
        username.setText(name);
        String pass = data.getStringExtra("pass");
        userpass.setText(pass);
    }
}
