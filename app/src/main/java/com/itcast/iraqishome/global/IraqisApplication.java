package com.itcast.iraqishome.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by yb on 2017/11/21.
 */

public class IraqisApplication extends Application{
    private static Context context;
    private static Handler handler;
    private static int mainThreadId;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();
    }
    public static int getMainThreadId() {
        return mainThreadId;
    }

    public static Context getContext() {
        return context;
    }

    public static Handler getHandler() {
        return handler;
    }
}
