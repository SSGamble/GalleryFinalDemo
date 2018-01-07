package com.qr.galleryfinaldemo;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import cn.finalteam.galleryfinal.BuildConfig;
import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ImageLoader;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * ====================== BaseApplication ========================
 * 基类  完成一些 初始化 配置操作
 * @author SGamble
 */
public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //========================== GalleryFinal - 图片选择 ==========================
        //初始化 ImageLoader
        com.nostra13.universalimageloader.core.ImageLoader imageLoader = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
        //配置主题
        //ThemeConfig.CYAN
        ThemeConfig theme = new ThemeConfig.Builder()
        .build();
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(true)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(false)
                .setEnableRotate(true)
                .setEnablePreview(true)
        .build();
        //配置imageloader
        ImageLoader imageloader = new UILImageLoader();
        //设置核心配置信息
        CoreConfig coreConfig = new CoreConfig.Builder(this, imageloader, theme)
                .setDebug(BuildConfig.DEBUG)
                .setFunctionConfig(functionConfig)
        .build();
        GalleryFinal.init(coreConfig);
    }
}
