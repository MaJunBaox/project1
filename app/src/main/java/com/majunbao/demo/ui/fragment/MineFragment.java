package com.majunbao.demo.ui.fragment;

import com.majunbao.demo.R;
import com.majunbao.demo.common.MyLazyFragment;
import com.majunbao.demo.ui.activity.MainActivity;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2019/11/04
 *    desc   : 我的页面
 */
public final class MineFragment extends MyLazyFragment<MainActivity> {

    public static MineFragment newInstance() {
        return new MineFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public boolean isStatusBarEnabled() {
        // 使用沉浸式状态栏
        return !super.isStatusBarEnabled();
    }
}