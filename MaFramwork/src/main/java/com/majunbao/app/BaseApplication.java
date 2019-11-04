package com.majunbao.app;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * author : Majunbao
 * date : 2019/6/10 14:29
 * description :Application
 */
public class BaseApplication extends Application {
    private static final String LOG_TAG = "YZ_LOGGER";
    protected static Context context;
    protected static Handler handler;
    protected static int mainThreadId;
    private static BaseApplication mApp;

    public static synchronized BaseApplication getInstance() {
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        handler = new Handler();
        mainThreadId = android.os.Process.myTid();
        //Logger.init(LOG_TAG).logLevel(BuildConfig.IS_SHOW_LOG ? LogLevel.FULL : LogLevel.NONE);
    }

    /**
     * 获取上下文对象
     *
     * @return context
     */
    public static Context getContext() {
        return context;
    }

    /**
     * 获取全局handler
     *
     * @return 全局handler
     */
    public static Handler getHandler() {
        return handler;
    }

    /**
     * 获取主线程id
     *
     * @return 主线程id
     */
    public static int getMainThreadId() {
        return mainThreadId;
    }

    //解决64K
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
       // MultiDex.install(this);
    }
}
