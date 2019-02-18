package com.bw.yq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.bw.yq.Presenter.ShowPresenter;
import com.bw.yq.View.ShowView;
import com.bw.yq.adapter.MyAdapter;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity implements ShowView {

    private RecyclerView rlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = findViewById(R.id.rlv);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rlv.setLayoutManager(manager);
        ShowPresenter showPresenter=new ShowPresenter(this);
        showPresenter.sendShow();
    }

    @Override
    public void view(JSONArray data1) {
      //  Toast.makeText(this, data1.toString(), Toast.LENGTH_SHORT).show();
        MyAdapter myAdapter = new MyAdapter(this, data1);
        rlv.setAdapter(myAdapter);
        myAdapter.setOnItemClickListenter(new MyAdapter.OnItemClickListenter() {
            @Override
            public void onItemClick(int i) {

            }

            @Override
            public void onItemLongClick(int i) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("xxx","销毁了");
    }
}
