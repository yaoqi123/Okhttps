package com.bw.yq.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bw.yq.R;
import com.bw.yq.adapter.MyAdapter;
import com.bw.yq.presenter.ShowPresenter;
import com.bw.yq.view.ShowView;

import org.json.JSONArray;

public class Main2Activity extends AppCompatActivity implements ShowView{

    private RecyclerView rlv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rlv = findViewById(R.id.rlv);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rlv.setLayoutManager(manager);
        ShowPresenter showPresenter=new ShowPresenter((ShowView) this);
        showPresenter.sendShow();
    }

    @Override
    public void view(JSONArray data) {
        MyAdapter myAdapter = new MyAdapter(this, data);
        rlv.setAdapter(myAdapter);
        myAdapter.OnItemClickListenter(new MyAdapter.OnItemClickListenter() {
            @Override
            public void onItemClick(int i) {

            }

            @Override
            public void onItemLongClick(int i) {

            }
        });
    }
}
