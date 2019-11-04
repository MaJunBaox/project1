package com.majunbao.demo.net.interfaces;

/**
 * author : Majunbao
 * date : 2019/8/13 17:23
 * description : 定义通用接口
 */
public interface OnSelectListener {
    /**
     * 接口回调
     * @param position 下标索引
     */
    void onSelectOnClick(int position);

    /**
     * 接口回调2
     * @param position 下标
     * @param status 文案
     */
   // void onSelectOnClick(int position ,String status);

}
