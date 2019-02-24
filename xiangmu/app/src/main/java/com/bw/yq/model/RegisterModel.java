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
 * @fileName RegisterModel
 * @package com.bw.yq.model
 * @date 2019/2/21 13:55
 */
public class RegisterModel {
    private Map<String,String> map=new HashMap<>();
    private String url="http://172.17.8.100/small/user/v1/register";
    public interface OnRegisterModelListenter{
        void OnReg(String message,String status);
    }
    private OnRegisterModelListenter registermodellistenter;
    public void setOnRegisterModelListenter(OnRegisterModelListenter registermodellistenter) {
        this.registermodellistenter = registermodellistenter;
    }



    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                  String path= (String) msg.obj;
                    try {
                        JSONObject  jsonObject=new JSONObject("path");
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                              if (registermodellistenter!=null){
                                  registermodellistenter.OnReg(message,status);
                              }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    };
    public void Register(String name1, String pass1) {
        map.put("phone",name1);
        map.put("pwd",pass1);
        OkHttpsUtils.onIntents().DoPost(url, map, new Callback() {
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
