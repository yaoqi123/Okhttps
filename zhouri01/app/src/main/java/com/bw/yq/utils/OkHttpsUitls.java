package com.bw.yq.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author yaoqi
 * @fileName OkHttpsUitls
 * @package com.bw.yq.utils
 * @date 2019/2/17 15:14
 */
public class OkHttpsUitls {
    private static OkHttpsUitls okHttpsUitls = null;
    private static OkHttpsUitls okHttpsUitls1;

    private OkHttpsUitls(){

 }

 public static OkHttpsUitls OnIntents(){
    if (okHttpsUitls==null){
        synchronized (OkHttpsUitls.class){
            if (okHttpsUitls==null){
                okHttpsUitls1 = new OkHttpsUitls();
            }
        }
    }


     return okHttpsUitls;
 }
public  static  void DoPost(String name, String pass, String url, Callback callback){
    HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {

        }
    });
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    RequestBody requestBody=new FormBody.Builder().add("phone",name).add("pwd",pass).build();
    Request request=new Request.Builder().url(url).post(requestBody).build();
    Call call = okHttpClient.newCall(request);
    call.enqueue(callback);



}
public static void DoGet(String url,Callback callback){
    HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {

        }
    });
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    Request request=new Request.Builder().url(url).build();
    Call call = okHttpClient.newCall(request);
    call.enqueue(callback);

}
}


