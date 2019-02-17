package com.bw.yq.gggg.activity.adappter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.bw.yq.gggg.activity.bean.Users;

import java.util.ArrayList;

/**
 * @author yaoqi
 * @fileName MyAdapter
 * @package com.bw.yq.gggg.activity.adappter
 * @date 2019/2/14 11:53
 */
public class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Users> list;

    public MyAdapter(Context context, ArrayList<Users> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null;
    }

}
