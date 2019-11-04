package com.majunbao.demo.mvp;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2018/11/17
 *    desc   : MVP 模型基类
 */
public abstract class MvpModel<L> {

    private L mListener;

    public void setListener(L listener) {
        mListener = listener;
    }

    public L getListener() {
        return mListener;
    }
}