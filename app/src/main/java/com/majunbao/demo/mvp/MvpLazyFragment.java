package com.majunbao.demo.mvp;

import com.majunbao.demo.common.MyLazyFragment;
import com.majunbao.demo.mvp.proxy.IMvpPresenterProxy;
import com.majunbao.demo.mvp.proxy.MvpPresenterProxyImpl;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2018/11/17
 *    desc   : MVP 懒加载 Fragment 基类
 */
public abstract class MvpLazyFragment extends MyLazyFragment implements IMvpView {

    private IMvpPresenterProxy mMvpProxy;

    @Override
    protected void initFragment() {
        mMvpProxy = createPresenterProxy();
        mMvpProxy.bindPresenter();
        super.initFragment();
    }

    protected IMvpPresenterProxy createPresenterProxy() {
        return new MvpPresenterProxyImpl(this);
    }

    @Override
    public void onDestroy() {
        if (mMvpProxy != null) {
            mMvpProxy.unbindPresenter();
        }
        super.onDestroy();
    }
}