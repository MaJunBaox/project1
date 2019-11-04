package com.majunbao.demo.mvp.proxy;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2019/05/11
 *    desc   : 模型层代理接口
 */
public interface IMvpModelProxy {
    /**
     * 绑定 Model
     */
    void bindModel();

    /**
     * 解绑 Model
     */
    void unbindModel();
}