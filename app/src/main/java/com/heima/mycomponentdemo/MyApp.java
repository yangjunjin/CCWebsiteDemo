package com.heima.mycomponentdemo;

import android.app.Application;

import com.billy.cc.core.component.CC;

/**
 * author : yangjunjin
 * date : 2020/3/30 23:13
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            CC.enableDebug(true); // 默认是false: 关闭状态
            CC.enableVerboseLog(true);    // 默认是false: 关闭状态
            CC.enableRemoteCC(true); // 默认是false: 关闭状态
        }
    }
}
