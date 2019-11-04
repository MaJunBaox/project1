package com.majunbao.demo.net;

import com.majunbao.demo.bean.UserBean;
import com.majunbao.utils.CacheUtils;
import com.majunbao.utils.SPUtils;
import com.majunbao.utils.StringUtils;

/**
 * author : Majunbao
 * date : 2019/6/4 15:54
 * description :本地应用的一些服务方法
 */
public class AppEngine {

    private static final String COOKIE_PREFS = "CookiePrefsFile";


    /**
     * 保存或者更新用户凭证
     *
     * @param user 用户登录凭证
     */
    public static void saveOrUpdateUserCertificate(UserBean user){
        if (null !=user) {
            //缓存用户数据
            CacheUtils.getInstance().put("User" , user);
        }
    }

    /**
     * 判断用户是否登录
     *
     * @return
     */
    public static boolean isUserLogin() {
        UserBean user = findUserCertificate();
       /* if (null != user && 0!=user.getId()) {
            return true;
        }*/
        return false;
    }

    /**
     * 获取当前的用户登录凭证
     * 如果获取到的结果为空 可主动提示重新登录
     *
     * @return userEvidenceInfo
     */
    public static UserBean findUserCertificate() {
        UserBean userEvidenceInfo = null;
        //获取缓存数据
        userEvidenceInfo= (UserBean) CacheUtils.getInstance().getSerializable("User");
        if (null != userEvidenceInfo) {
            return userEvidenceInfo;
        } else {
            return new UserBean();
        }
    }

    /**
     * 清除当前登录用户的用户凭证
     */
    public static void clearUserEvidenceInfo() {
        //清空保存的用户信息
        CacheUtils.getInstance().remove("User");
    }



    /**
     *     /////////////////////////////////////////////////////////////////////////////////
     *     //
     *     //                      长青公海token相关
     *     //
     *     /////////////////////////////////////////////////////////////////////////////////
     */


    /**
     * 保存或者更新用户凭证
     *
     * @param user 用户登录凭证
     */
    public static void saveOrUpdateCqUserCertificate(UserBean user){
        if (StringUtils.isNotEmpty(user)) {
            //缓存用户数据
            //SPUtils.getInstance("token").put("token" , token);
            CacheUtils.getInstance().put("CqUser" , user);
        }
    }

    /**
     * 清除当前登录用户的用户凭证
     */
    public static void clearCqUserEvidenceInfo() {
        //清空保存的用户信息
        CacheUtils.getInstance().remove("CqUser");
    }

    public static String getToken(){
        //缓存用户数据
        String token = SPUtils.getInstance("token").getString("token");
        return token;
    }


    /**
     * 获取当前的用户登录凭证
     * 如果获取到的结果为空 可主动提示重新登录
     *
     * @return userEvidenceInfo
     */
    public static UserBean findCqUserCertificate() {
        UserBean userEvidenceInfo = null;
        //获取缓存数据
        userEvidenceInfo= (UserBean) CacheUtils.getInstance().getSerializable("CqUser");
        if (null != userEvidenceInfo) {
            return userEvidenceInfo;
        } else {
            return new UserBean();
        }
    }

    /**
     * 判断用户是否登录
     *
     * @return
     */
    public static boolean isCqUserLogin() {
        UserBean user = findCqUserCertificate();
       /* if (null != user && 0!=user.getId()) {
            return true;
        }*/
        return false;
    }

}
