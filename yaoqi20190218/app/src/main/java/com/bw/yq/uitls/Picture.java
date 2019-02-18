package com.bw.yq.uitls;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @author yaoqi
 * @fileName Picture
 * @package com.bw.yq.uitls
 * @date 2019/2/18 9:38
 */
public class Picture extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);

    }
}
