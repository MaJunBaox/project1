package com.majunbao.demo.ui.activity;

import android.view.View;
import android.view.animation.Animation;

import com.gyf.immersionbar.BarHide;
import com.majunbao.demo.R;
import com.majunbao.demo.common.MyActivity;
import com.majunbao.demo.other.AppConfig;
import com.hjq.permissions.OnPermission;
import com.hjq.permissions.Permission;
import com.hjq.permissions.XXPermissions;

import java.util.List;

import butterknife.BindView;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2018/10/18
 *    desc   : 闪屏界面
 */
public final class SplashActivity extends MyActivity
        implements OnPermission{

    @BindView(R.id.iv_splash_bg)
    View mImageView;
    @BindView(R.id.tv_splash_debug)
    View mDebugView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        // 设置状态栏和导航栏参数
        getStatusBarConfig()
                // 有导航栏的情况下，activity全屏显示，也就是activity最下面被导航栏覆盖，不写默认非全屏
                .fullScreen(true)
                // 隐藏状态栏
                .hideBar(BarHide.FLAG_HIDE_STATUS_BAR)
                // 透明导航栏，不写默认黑色(设置此方法，fullScreen()方法自动为true)
                .transparentNavigationBar()
                .init();
    }

    @Override
    protected void initData() {
        if (AppConfig.isDebug()) {
            mDebugView.setVisibility(View.VISIBLE);
        } else {
            mDebugView.setVisibility(View.INVISIBLE);
        }
        requestPermission();
    }

    private void requestPermission() {
        XXPermissions.with(this)
                .permission(Permission.Group.STORAGE)
                .request(this);
    }

    /**
     * {@link OnPermission}
     */

    @Override
    public void hasPermission(List<String> granted, boolean isAll) {
        startActivityFinish(MainActivity.class);
    }

    @Override
    public void noPermission(List<String> denied, boolean quick) {
        if (quick) {
            toast(R.string.common_permission_fail);
            XXPermissions.gotoPermissionSettings(SplashActivity.this, true);
        } else {
            toast(R.string.common_permission_hint);
            postDelayed(this::requestPermission, 1000);
        }
    }

    @Override
    public void onBackPressed() {
        //禁用返回键
        //super.onBackPressed();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (XXPermissions.isHasPermission(SplashActivity.this, Permission.Group.STORAGE)) {
            hasPermission(null, true);
        } else {
            requestPermission();
        }
    }

}