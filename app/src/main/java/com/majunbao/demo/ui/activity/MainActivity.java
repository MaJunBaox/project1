package com.majunbao.demo.ui.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.majunbao.base.BaseFragmentAdapter;
import com.majunbao.demo.R;
import com.majunbao.demo.common.MyActivity;
import com.majunbao.demo.common.MyLazyFragment;
import com.majunbao.demo.helper.ActivityStackManager;
import com.majunbao.demo.helper.DoubleClickHelper;
import com.majunbao.demo.other.KeyboardWatcher;
import com.majunbao.demo.ui.fragment.HomeFragment;
import com.majunbao.demo.ui.fragment.MineFragment;
import com.majunbao.demo.ui.fragment.ShopFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * author : Majunbao
 * github : https://github.com/MaJunBaox
 * time   : 2019/11/04
 * desc   : 主页界面
 */

public final class MainActivity extends MyActivity implements ViewPager.OnPageChangeListener,
        KeyboardWatcher.SoftKeyboardStateListener {

    @BindView(R.id.vp_home_pager)
    ViewPager mViewPager;
    @BindView(R.id.tvHome)
    TextView tvHome;
    @BindView(R.id.tvShop)
    TextView tvShop;
    @BindView(R.id.tvMine)
    TextView tvMine;
    @BindView(R.id.llTab)
    LinearLayout llTab;
    private int tab = 0;

    /**
     * ViewPager 适配器
     */
    private BaseFragmentAdapter<MyLazyFragment> mPagerAdapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mViewPager.addOnPageChangeListener(this);
        KeyboardWatcher.with(this)
                .setListener(this);
    }

    @Override
    protected void initData() {
        mPagerAdapter = new BaseFragmentAdapter<>(this);
        mPagerAdapter.addFragment(HomeFragment.newInstance());
        mPagerAdapter.addFragment(ShopFragment.newInstance());
        mPagerAdapter.addFragment(MineFragment.newInstance());
        mViewPager.setAdapter(mPagerAdapter);
        // 限制页面数量
        mViewPager.setOffscreenPageLimit(mPagerAdapter.getCount());
        setSelected(tab);
    }

    /**
     * 点击事件 切换Fragment
     * @param view
     */
    @OnClick({R.id.tvHome, R.id.tvShop, R.id.tvMine})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvHome:
                tab = 0;
                mViewPager.setCurrentItem(tab);
                setSelected(tab);
                break;
            case R.id.tvShop:
                tab = 1;
                mViewPager.setCurrentItem(tab);
                setSelected(tab);
                break;
            case R.id.tvMine:
                tab = 2;
                mViewPager.setCurrentItem(tab);
                setSelected(tab);
                break;
        }
    }


    /**
     * {@link ViewPager.OnPageChangeListener}
     * viewPager回调不作操作
     */

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }


    /**
     * {@link KeyboardWatcher.SoftKeyboardStateListener}
     */
    @Override
    public void onSoftKeyboardOpened(int keyboardHeight) {
          llTab.setVisibility(View.GONE);
    }

    @Override
    public void onSoftKeyboardClosed() {
        llTab.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 回调当前 Fragment 的 onKeyDown 方法
        if (mPagerAdapter.getCurrentFragment().onKeyDown(keyCode, event)) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (DoubleClickHelper.isOnDoubleClick()) {
            //移动到上一个任务栈，避免侧滑引起的不良反应
            moveTaskToBack(false);
            postDelayed(new Runnable() {

                @Override
                public void run() {
                    // 进行内存优化，销毁掉所有的界面
                    ActivityStackManager.getInstance().finishAllActivities();
                    // 销毁进程（请注意：调用此 API 可能导致当前 Activity onDestroy 方法无法正常回调）
                    // System.exit(0);
                }
            }, 300);
        } else {
            toast(R.string.home_exit_hint);
        }
    }

    @Override
    protected void onDestroy() {
        mViewPager.removeOnPageChangeListener(this);
        mViewPager.setAdapter(null);
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private void setSelected(int tab) {
        tvHome.setTextColor(tab == 0 ? getResources().getColor(R.color.color13347B) : getResources().getColor(R.color.color000000));
        tvShop.setTextColor(tab == 1 ? getResources().getColor(R.color.color13347B) : getResources().getColor(R.color.color000000));
        tvMine.setTextColor(tab == 2 ? getResources().getColor(R.color.color13347B) : getResources().getColor(R.color.color000000));
        tvHome.setSelected(tab == 0);
        tvShop.setSelected(tab == 1);
        tvMine.setSelected(tab == 2);
    }
}