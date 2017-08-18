package com.victor.common;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by victor on 2017/8/17.
 */

public class BaseApplication extends Application {


    @Override
    public void onCreate() {
      super.onCreate();
        if (isApkInDebug(this)) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    /**
     * 判断当前应用是否是debug状态
     *
     */
    public static boolean isApkInDebug(Context context) {
        try {
            ApplicationInfo info = context.getApplicationInfo();
            return (info.flags & ApplicationInfo.FLAG_DEBUGGABLE) != 0;
        } catch (Exception e) {
            return false;
        }
    }
}
