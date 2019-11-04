package com.majunbao.demo.mvp.copy;

import com.majunbao.demo.mvp.IMvpView;

import java.util.List;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2018/11/17
 *    desc   : 可进行拷贝的契约类
 */
public final class CopyContract {

    public interface View extends IMvpView {

        void loginSuccess(List<String> data);

        void loginError(String msg);
    }

    public interface Presenter {

        void login(String account, String password);
    }
}