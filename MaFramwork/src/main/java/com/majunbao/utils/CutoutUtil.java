package com.majunbao.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.majunbao.app.BaseApplication;
import java.lang.reflect.Method;

/**
 * author : Majunbao
 * date : 2019/6/11 13:45
 * description : 判断是否是允许全屏界面内容显示到刘海区域的刘海屏机型
 *
 * 在你的应用中，你期望某些全屏界面在刘海屏机型上必须全屏展示，那你就自行将界面元素适当下移，从而避免被刘海遮挡；而某些全屏界面不是非要全屏显示，允许在刘海屏机型显示状态栏，那就通过显示状态栏的方式，从而避免被刘海遮挡。
 *
 * 为了实现这种效果，我们需要标记区分哪些界面必须全屏展示、哪些界面允许显示状态栏。这里提供一种实现方式，让允许显示状态栏的界面 Activity 继承一个接口，比如：
 *
 * public interface CutoutAdapt {
 * }
 *
 * 然后在 ActivityLifecycleCallbacks 回调，统一适配允许通过显示状态栏的全屏界面：
 *
 * @Override
 * public void onActivityStarted(Activity activity) {
 *     // 如果是允许全屏显示到刘海屏区域的刘海屏机型
 *     if (CutoutUtil.allowDisplayToCutout()) {
 *         if (isFullScreen(activity)) {
 *             // 如果允许通过显示状态栏方式适配刘海屏
 *             if (activity instanceof CutoutAdapt) {
 *                 // 显示状态栏
 *                 StatusBarUtil.showStatusbar(activity.getWindow());
 *             } else {
 *                 // 需自行将该界面视图元素下移，否则可能会被刘海遮挡
 *             }
 *         } else {
 *             // 非全屏界面无需适配刘海屏
 *         }
 *     }
 * }
 *
 * https://www.jianshu.com/p/c9e710a9fa35
 *
 */
public class CutoutUtil {

    private static Boolean sAllowDisplayToCutout;


    /**
     * 是否为允许全屏界面显示内容到刘海区域的刘海屏机型（与AndroidManifest中配置对应）
     */
    public static boolean allowDisplayToCutout() {
        if (sAllowDisplayToCutout == null) {
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O_MR1) {
                // 9.0系统全屏界面默认会保留黑边，不允许显示内容到刘海区域
                return sAllowDisplayToCutout = false;
            }
            Context context = BaseApplication.getContext();
            if (hasCutout_Huawei(context)) {
                return sAllowDisplayToCutout = true;
            }
            if (hasCutout_OPPO(context)) {
                return sAllowDisplayToCutout = true;
            }
            if (hasCutout_VIVO(context)) {
                return sAllowDisplayToCutout = true;
            }
            if (hasCutout_XIAOMI(context)) {
                return sAllowDisplayToCutout = true;
            }
            return sAllowDisplayToCutout = false;
        } else {
            return sAllowDisplayToCutout;
        }
    }


    /**
     * 是否是华为刘海屏机型
     */
    @SuppressWarnings("unchecked")
    private static boolean hasCutout_Huawei(Context context) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            return false;
        }
        try {
            ClassLoader cl = context.getClassLoader();
            Class HwNotchSizeUtil = cl.loadClass("com.huawei.android.util.HwNotchSizeUtil");
            if (HwNotchSizeUtil != null) {
                Method get = HwNotchSizeUtil.getMethod("hasNotchInScreen");
                return (boolean) get.invoke(HwNotchSizeUtil);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否是oppo刘海屏机型
     */
    @SuppressWarnings("unchecked")
    private static boolean hasCutout_OPPO(Context context) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("oppo")) {
            return false;
        }
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    /**
     * 是否是vivo刘海屏机型
     */
    @SuppressWarnings("unchecked")
    private static boolean hasCutout_VIVO(Context context) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("vivo")) {
            return false;
        }
        try {
            ClassLoader cl = context.getClassLoader();
            @SuppressLint("PrivateApi")
            Class ftFeatureUtil = cl.loadClass("android.util.FtFeature");
            if (ftFeatureUtil != null) {
                Method get = ftFeatureUtil.getMethod("isFeatureSupport", int.class);
                return (boolean) get.invoke(ftFeatureUtil, 0x00000020);
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 是否是小米刘海屏机型
     */
    @SuppressWarnings("unchecked")
    private static boolean hasCutout_XIAOMI(Context context) {
        if (!Build.MANUFACTURER.equalsIgnoreCase("xiaomi")) {
            return false;
        }
        try {
            ClassLoader cl = context.getClassLoader();
            @SuppressLint("PrivateApi")
            Class SystemProperties = cl.loadClass("android.os.SystemProperties");
            Class[] paramTypes = new Class[2];
            paramTypes[0] = String.class;
            paramTypes[1] = int.class;
            Method getInt = SystemProperties.getMethod("getInt", paramTypes);
            //参数
            Object[] params = new Object[2];
            params[0] = "ro.miui.notch";
            params[1] = 0;
            return (Integer) getInt.invoke(SystemProperties, params) == 1;
        } catch (Exception e) {
            return false;
        }
    }

}
