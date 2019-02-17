package com.bw.yq.model;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.bw.yq.utils.OkHttpsUitls;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @author yaoqi
 * @fileName RegisterModel
 * @package com.bw.yq.model
 * @date 2019/2/17 15:52
 */
public class RegisterModel {
    private String url="http://172.17.8.100/small/user/v1/register";
    public interface OnRegisterListenter{
        void Onstat(String message,String status);
    }
    private OnRegisterListenter registerlistenter;

    public void OnRegisterListenter(OnRegisterListenter registerlistenter) {
        this.registerlistenter = registerlistenter;
    }



    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
           String path= (String) msg.obj;
                    try {
                        JSONObject jsonObject=new JSONObject(path);
                        String message = jsonObject.getString("message");
                        String status = jsonObject.getString("status");
                        if (registerlistenter!=null){
                            registerlistenter.Onstat(message,status);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                    break;
            }
        }
    };
    public void Register(String name1, String pass1) {
        OkHttpsUitls.OnIntents().DoPost(name1, pass1, url, new Callback() {
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
