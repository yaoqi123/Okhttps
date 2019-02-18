package com.bw.yq.Model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import com.bw.yq.uitls.UitlsOkHttps;

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
 * @package com.bw.yq.Model
 * @date 2019/2/18 8:51
 */
public class ShowModel {
    private String url="http://365jia.cn/news/api3/365jia/news/headline?page=1";
    public interface OnShowListenter{
        void OnData(JSONArray data1);

    }
    private OnShowListenter showlistenter;

    public void OnShowListenter(OnShowListenter showlistenter) {
        this.showlistenter = showlistenter;
    }



    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
             String path= (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(path);
                        JSONObject data = jsonObject.getJSONObject("data");
                        JSONArray data1 = data.getJSONArray("data");
                        if (showlistenter!=null){
                            showlistenter.OnData(data1);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };
    public void Show() {
        UitlsOkHttps.OnIents().DoGet(url, new Callback() {
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
