package com.bw.yq.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.yq.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author yaoqi
 * @fileName MyAdapter
 * @package com.bw.yq.adapter
 * @date 2019/2/18 9:18
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private Context context;
private JSONArray data1;
private static final int ONE=0;
private static final int TWO=1;

    public MyAdapter(Context context, JSONArray data1) {
        this.context = context;
        this.data1 = data1;
    }
public interface OnItemClickListenter{
        void onItemClick(int i);
        void onItemLongClick(int i);
}
    private OnItemClickListenter itemClickListenter;
    public void setOnItemClickListenter(OnItemClickListenter itemClickListenter) {
        this.itemClickListenter = itemClickListenter;
    }



    @Override
    public int getItemViewType(int position) {
        if (position%4==0){
            return ONE;
        }else {
            return TWO;
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i==ONE){
            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout,null,false);

            MyViewHolder viewHolder=new MyViewHolder(view);
            return viewHolder;

        }else {
            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout2,null,false);
            MyViewHolder1 myViewHolder1=new MyViewHolder1(view);
            return myViewHolder1;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int itemViewType = getItemViewType(i);
        if (itemViewType==ONE){
            MyViewHolder viewHolder1= (MyViewHolder) viewHolder;
            try {
                JSONObject jsonObject = data1.getJSONObject(i);
                String title = jsonObject.getString("title");
                JSONArray pics = jsonObject.getJSONArray("pics");
                String string = pics.getString(0);

                viewHolder1.tv1.setText(title);
                ImageLoader.getInstance().displayImage(string,viewHolder1.img);
              viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                  @Override
                  public boolean onLongClick(View v) {
                      itemClickListenter.onItemLongClick(i);

                      return true;
                  }
              });

            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
           MyViewHolder1 myViewHolder1= (MyViewHolder1) viewHolder;
            try {
                JSONObject object = data1.getJSONObject(i);
                String title = object.getString("title");
                String pics = object.getString("pics");
                myViewHolder1.tv2.setText(title);
                ImageLoader.getInstance().displayImage(pics,myViewHolder1.img2);
                     myViewHolder1.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                         @Override
                         public boolean onLongClick(View v) {
                             itemClickListenter.onItemLongClick(i);
                             return true;
                         }
                     });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public int getItemCount() {
        return data1.length();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv1;
        private final ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            img = itemView.findViewById(R.id.img);
        }
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {

        private final TextView tv2;
        private final ImageView img2;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tv2);
            img2 = itemView.findViewById(R.id.img2);
        }
    }
}
