package com.majunbao.demo.net;


import com.majunbao.demo.bean.BaseResBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author : Majunbao
 * date : 2019/8/3 21:07
 * description : 接口
 *     @Headers("Content-Type:application/json")
 */
public interface MainService {

    /* ≡※≡※≡※≡※≡※≡※≡※≡※≡※≡ 账号密码相关Start ※≡※≡※≡※≡※≡※≡※≡※≡※≡※ */

    /**
     * 账号密码登录
     * @param phone 手机号
     * @param pwd 密码
     * @return
     */
    @GET("app_login")
    Observable<BaseResBean> appLogin(@Query("phone") String phone,
                                     @Query("password") String pwd);
}