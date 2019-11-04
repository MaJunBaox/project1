package com.majunbao.demo.net;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2019/6/3 15:35
 *    desc   : 常量配置类
 */
public class HttpConstants {
    //配置开发测试正式环境变量
    private static final int status = 5 ;//0开发 1测试 2正式 3新服务器 4木库 5长青在线

    //服务端地址：{develop,test,standard}
    private static final String[] SERVER_ADDRESSES = {"http://test.codingfly.com:8088/",
            "http://test.codingfly.com:8088/", "http://59.110.238.149/","http://app.xianbing100.com"
            ,"http://47.94.226.125/" , "http://ivying.com/" , "https://mchat.ivying.com/" ,"http://chat.ivying.com/"};
    //当前服务器地址
    public static final String SERVER_ADDRESS = SERVER_ADDRESSES[status];

    public static final String LOCAL_SHARE_IMAGENAME = "ic_launcher.png";
    public static final String SERVER_ADDRESS2 = SERVER_ADDRESSES[7];

    public static final String PAY_EVENT = "PAY";

}
