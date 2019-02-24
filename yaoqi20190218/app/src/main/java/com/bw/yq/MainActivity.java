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
    private ShowPresenter showPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlv = findViewById(R.id.rlv);
        LinearLayoutManager manager=new LinearLayoutManager(this);
        rlv.setLayoutManager(manager);
        showPresenter = new ShowPresenter(this);
        showPresenter.Accthach(this);
        showPresenter.sendShow();
    }

    @Override
    public void view(final JSONArray data1) {
      //  Toast.makeText(this, data1.toString(), Toast.LENGTH_SHORT).show();
        final MyAdapter myAdapter = new MyAdapter(this, data1);
        rlv.setAdapter(myAdapter);
        myAdapter.setOnItemClickListenter(new MyAdapter.OnItemClickListenter() {
            @Override
            public void onItemClick(int i) {


            }

            @Override
            public void onItemLongClick(int i) {
                data1.remove(i);
                myAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.Xie();
        Log.i("xxx","销毁了");
    }
}
