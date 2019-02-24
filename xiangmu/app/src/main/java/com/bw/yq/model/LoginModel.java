package com.bw.yq.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.yq.utils.OkHttpsUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author yaoqi
 * @fileName LoginModel
 * @package com.bw.yq.model
 * @date 2019/2/18 19:27
 */
public class LoginModel {
    Map<String, String> map = new HashMap<>();

    public interface OnLoginModelListenter{
        void OnStatus(String status);

    }
    private OnLoginModelListenter loginmodellistenter;

    public void setOnLoginModelListenter(OnLoginModelListenter loginmodellistenter) {
        this.loginmodellistenter = loginmodellistenter;
    }



    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    String path = (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(path);
                        String status = jsonObject.getString("status");
                           if (loginmodellistenter!=null){
                               loginmodellistenter.OnStatus(status);
                           }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
            }
        }
    };

    String url = "http://172.17.8.100/small/user/v1/login";

    public void Show(String name, String pass) {
        map.put("phone", name);
        map.put("pwd", pass);
        OkHttpsUtils.onIntents().DoPost(url, map, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i("yao", e.toString());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Log.i("xxx", string);
                Message message = new Message();
                message.what = 0;
                message.obj = string;
                handler.sendMessage(message);
            }
        });
    }
}
