package com.majunbao.demo.ui.fragment;

import com.majunbao.demo.R;
import com.majunbao.demo.common.MyLazyFragment;
import com.majunbao.demo.ui.activity.MainActivity;
import com.majunbao.widget.view.SwitchButton;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2019/11/04
 *    desc   : 商城
 */
public final class ShopFragment extends MyLazyFragment<MainActivity>
        implements SwitchButton.OnCheckedChangeListener {

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_shop;
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

    /**
     * {@link SwitchButton.OnCheckedChangeListener}
     */

    @Override
    public void onCheckedChanged(SwitchButton button, boolean isChecked) {
        toast(isChecked);
    }
}