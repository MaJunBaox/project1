package com.majunbao.demo.net.helper;


import com.majunbao.demo.net.AppEngine;
import com.majunbao.utils.StringUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * author : Majunbao
 * github : https://github.com/MaJunBaox
 * time   : 2019/8/27 10:02
 * desc   : Token处理
 */
public class TokenIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String token = AppEngine.getToken();
        if (StringUtils.isEmpty(token)) {
            Request originalRequest = chain.request();
            return chain.proceed(originalRequest);
        }else {
            Request originalRequest = chain.request();
            Request updateRequest = originalRequest.newBuilder().header("access_token", token).build();
            return chain.proceed(updateRequest);
        }
    }
}
