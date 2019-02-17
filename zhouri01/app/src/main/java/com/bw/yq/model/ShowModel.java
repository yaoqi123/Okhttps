package com.bw.yq.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.yq.utils.OkHttpsUitls;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author yaoqi
 * @fileName ShowModel
 * @package com.bw.yq.model
 * @date 2019/2/17 16:19
 */
public class ShowModel {
    private String url="http://www.xieast.com/api/news/news.php?page=1";
    public interface OnShowListenter{
        void OnShow(JSONArray data);
    }

    public void OnShowListenter(OnShowListenter showlistenter) {
        this.showlistenter = showlistenter;
    }

    private OnShowListenter showlistenter;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                 String path= (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(path);
                        JSONArray data = jsonObject.getJSONArray("data");
                           if (showlistenter!=null){
                               showlistenter.OnShow(data);
                           }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };
    public void Show() {
        OkHttpsUitls.OnIntents().DoGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("xxx",string);
                Message message = new Message();
                message.what=0;
                message.obj=string;
                handler.sendMessage(message);
            }
        });
    }
}
