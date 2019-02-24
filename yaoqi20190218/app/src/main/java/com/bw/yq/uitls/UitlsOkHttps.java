package com.bw.yq.uitls;

import android.support.v7.widget.LinearLayoutManager;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @author yaoqi
 * @fileName UitlsOkHttps
 * @package com.bw.yq.uitls
 * @date 2019/2/18 8:52
 */
public class UitlsOkHttps {
    private static UitlsOkHttps uitlsOkHttps=null;
    private static UitlsOkHttps uitlsOkHttps1;

    public UitlsOkHttps(){

    }

    public static UitlsOkHttps OnIents(){
        if (uitlsOkHttps==null){
            synchronized (UitlsOkHttps.class){

                if (uitlsOkHttps==null){
                    uitlsOkHttps1 = new UitlsOkHttps();
                }
            }
        }

        return uitlsOkHttps;
    }
    public static void DoGet(String url, Callback callback){
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
    public static void DoPost(String url,Callback callback){
        HttpLoggingInterceptor loggingInterceptor=new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {

            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
        RequestBody requestBody=new FormBody.Builder().build();
        Request request=new Request.Builder().url(url).post(requestBody).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);

    }
}
