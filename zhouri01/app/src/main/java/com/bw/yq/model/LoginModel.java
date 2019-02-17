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
 * @fileName LoginModel
 * @package com.bw.yq.model
 * @date 2019/2/17 15:12
 */
public class LoginModel {
   private String url="http://172.17.8.100/small/user/v1/login";
   public interface OnLoginListenter{
       void OnStats(String status);
   }

    public void OnLoginListenter(OnLoginListenter loginlistenter) {
        this.loginlistenter = loginlistenter;
    }

    private OnLoginListenter loginlistenter;

   Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           switch (msg.what){
               case 0:
           String path= (String) msg.obj;
                   try {
                       JSONObject jsonObject=new JSONObject(path);
                       String status = jsonObject.getString("status");
                       if (loginlistenter!=null){
                           loginlistenter.OnStats(status);
                       }
                   } catch (Exception e) {
                       e.printStackTrace();
                   }


                   break;
           }
       }
   };
    public void Login(String name, String pass) {

        OkHttpsUitls.OnIntents().DoPost(name, pass, url, new Callback() {
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
