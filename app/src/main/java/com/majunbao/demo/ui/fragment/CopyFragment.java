package com.majunbao.demo.ui.fragment;

import com.majunbao.demo.R;
import com.majunbao.demo.common.MyLazyFragment;
import com.majunbao.demo.ui.activity.CopyActivity;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2018/10/18
 *    desc   : 可进行拷贝的副本
 */
public final class CopyFragment extends MyLazyFragment<CopyActivity> {

    public static CopyFragment newInstance() {
        return new CopyFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_copy;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}