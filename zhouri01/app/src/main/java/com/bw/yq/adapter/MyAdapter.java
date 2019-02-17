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
 * @date 2019/2/17 16:36
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
private Context context;
private JSONArray data;
private static final int ONE=0;
private static final int TWO=1;


    public MyAdapter(Context context, JSONArray data) {
        this.context = context;
        this.data = data;
    }
public interface OnItemClickListenter{
        void onItemClick(int i);
        void onItemLongClick(int i);
}
    private OnItemClickListenter onItemClickListenter;

    public void OnItemClickListenter(OnItemClickListenter onItemClickListenter) {
        this.onItemClickListenter = onItemClickListenter;
    }



    @Override
    public int getItemViewType(int position) {
        if (position%2==0){
            return ONE;
        }else{
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

        }else if(i==TWO){
            View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout1,null,false);
            MyViewHolder1 myViewHolder1=new MyViewHolder1(view);
            return myViewHolder1;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        int type = getItemViewType(i);
        if (type==ONE){
            MyViewHolder viewHolder1= (MyViewHolder) viewHolder;

            try {
                JSONObject jsonObject = data.getJSONObject(i);
                String author_name = jsonObject.getString("author_name");
                String thumbnail_pic_s = jsonObject.getString("thumbnail_pic_s");
                viewHolder1.tv1.setText(author_name);
                ImageLoader.getInstance().displayImage(thumbnail_pic_s,viewHolder1.img);
                viewHolder1.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onItemClickListenter.onItemClick(i);
                    }
                });
                viewHolder1.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        onItemClickListenter.onItemLongClick(i);
                        return true;
                    }
                });
            } catch (Exception e) {

                e.printStackTrace();
            }
        }else if(type==TWO){
            MyViewHolder1 myViewHolder1= (MyViewHolder1) viewHolder;
            try {
                JSONObject jsonObject = data.getJSONObject(i);
                String author_name = jsonObject.getString("author_name");
                String thumbnail_pic_s = jsonObject.getString("thumbnail_pic_s");
                String thumbnail_pic_s02 = jsonObject.getString("thumbnail_pic_s02");
                myViewHolder1.tv2.setText(author_name);
                ImageLoader.getInstance().displayImage(thumbnail_pic_s,myViewHolder1.img1);
                ImageLoader.getInstance().displayImage(thumbnail_pic_s02,myViewHolder1.img2);
            } catch (Exception e) {

                e.printStackTrace();
            }


        }

    }

    @Override
    public int getItemCount() {
        return data.length();
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
        private final ImageView img1;
        private final ImageView img2;

        public MyViewHolder1(@NonNull View itemView) {
            super(itemView);
            tv2 = itemView.findViewById(R.id.tv2);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);

        }
    }


}
