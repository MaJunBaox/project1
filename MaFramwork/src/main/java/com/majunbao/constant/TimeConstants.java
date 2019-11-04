package com.majunbao.constant;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * author : Majunbao
 * github : https://github.com/MaJunBaox
 * time   : 2019/8/27 11:01
 * desc   : 时间辅助类
 */
public class TimeConstants {

    public static final int MSEC = 1;
    public static final int SEC  = 1000;
    public static final int MIN  = 60000;
    public static final int HOUR = 3600000;
    public static final int DAY  = 86400000;

    @IntDef({MSEC, SEC, MIN, HOUR, DAY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Unit {
    }
}
