package com.majunbao.demo.mvp.proxy;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2019/05/11
 *    desc   : 逻辑层代理接口
 */
public interface IMvpPresenterProxy {
    /**
     * 绑定 Presenter
     */
    void bindPresenter();

    /**
     * 解绑 Presenter
     */
    void unbindPresenter();
}