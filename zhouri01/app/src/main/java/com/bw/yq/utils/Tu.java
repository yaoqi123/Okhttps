package com.bw.yq.utils;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * @author yaoqi
 * @fileName Tu
 * @package com.bw.yq.utils
 * @date 2019/2/17 16:57
 */
public class Tu extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(configuration);
    }
}
