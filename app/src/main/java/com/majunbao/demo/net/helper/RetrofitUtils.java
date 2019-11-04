package com.majunbao.demo.net.helper;

import com.majunbao.demo.bean.BaseResBean;
import com.majunbao.demo.common.MyApplication;
import com.majunbao.demo.net.AppEngine;
import com.majunbao.demo.net.HttpConstants;
import com.majunbao.demo.net.cookie.CookieJarImpl;
import com.majunbao.demo.net.cookie.store.CookieStore;
import com.majunbao.demo.net.cookie.store.PersistentCookieStore;
import com.majunbao.demo.net.helper.okhttp.CacheInterceptor;
import com.majunbao.demo.net.helper.okhttp.intercepter.LoggingInterceptor;
import com.majunbao.demo.net.helper.okhttp.intercepter.LoggingLevel;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 两个域名 配置两个请求
 * 网络请求 retrofit
 */
public class RetrofitUtils {
    private static volatile RetrofitUtils retrofitUtils;
    private final OkHttpClient okHttpClient;
    public static CookieStore cookieStore;
    public static final String RESPONSE_SUCCESS = "请求成功";


    /**
     * 双重检验锁
     * @return
     */
    public static RetrofitUtils getInstance() {
        if (retrofitUtils==null) {
            synchronized (RetrofitUtils.class){
                if (retrofitUtils==null) {
                    retrofitUtils=new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }


    private RetrofitUtils() {
        //设置日志拦截器
        //HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
        //httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (cookieStore == null) {
            cookieStore = new PersistentCookieStore(
                    MyApplication.getAppContext());
        }
        LoggingInterceptor interceptor = new LoggingInterceptor(LoggingLevel.ALL);
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)//设置日志拦截器
                .writeTimeout(5, TimeUnit.SECONDS)//写入超时时间
                .readTimeout(5,TimeUnit.SECONDS)//读取超时时间
                .connectTimeout(5,TimeUnit.SECONDS)//超时时间
                // .addInterceptor(new HeaderInterceptor())//头部拦截器
                .addNetworkInterceptor(new CacheInterceptor())
                .cookieJar(new CookieJarImpl(cookieStore) )
                .build();
    }

    /**
     * 可动态配置域名
     * @param baseUrl  域名 HttpConstans
     * @param cls
     * @param <T>
     * @return
     */
    //retrofit-rxjava-rxandroid
    public <T> T createApi(String baseUrl,Class<T> cls){
        Retrofit retrofit=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(cls);
    }

    /**
     * 默认不需要传域名
     * @param cls
     * @param <T>
     * @return
     */
    public <T> T createApi(Class<T> cls){
        Retrofit retrofit=new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(HttpConstants.SERVER_ADDRESS)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(cls);
    }

    /**
     * 判断请求是否成功
     *
     * @param body 请求返回体
     * @return RESPONSE_SUCCESS 成功，其他失败
     */
    public static String judgeResponse(BaseResBean body) {
        if (null != body) {
            if (body.isOK()) {
                return RESPONSE_SUCCESS;
            }else {
                if ("6".equals(body.getStatus())) {
                    AppEngine.clearUserEvidenceInfo();
                    return "用户没有登录";
                }
                return body.getMsg();
            }
        }
        return "网络异常,请稍后尝试";
    }
}
