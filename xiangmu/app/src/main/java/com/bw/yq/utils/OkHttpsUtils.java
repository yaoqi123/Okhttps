package com.bw.yq.utils;

import android.util.Log;

import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author yaoqi
 * @fileName OkHttpsUtils
 * @package com.bw.yq.utils
 * @date 2019/2/18 19:35
 */
public class OkHttpsUtils {
    private static OkHttpsUtils okHttpsUtils=null;
    private OkHttpsUtils(){

    }
    public static OkHttpsUtils onIntents(){
        if (okHttpsUtils==null){
            synchronized (OkHttpsUtils.class){
                if (okHttpsUtils==null){
                    okHttpsUtils=new OkHttpsUtils();
                }
            }

        }
        return okHttpsUtils;
    }
    private static OkHttpClient okHttpClient=null;
    public synchronized static OkHttpClient getOkHttpClient(){
        if (okHttpClient==null){
            HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.i("xxx",message);
                }
            });
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();

        }
        return okHttpClient;
    }
    public void DoPost(String url, Map<String,String> parmars, Callback callback){
        OkHttpClient okHttpClient=getOkHttpClient();
        FormBody.Builder builder=new FormBody.Builder();
        for (String key:parmars.keySet()) {
            builder.add(key,parmars.get(key));
        }
        FormBody formBody=builder.build();
        Request request=new Request.Builder().url(url).post(formBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }
    public  void DoGet(String url,Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder().url(url).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }
}
