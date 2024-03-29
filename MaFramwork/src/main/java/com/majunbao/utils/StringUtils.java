package com.majunbao.utils;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * author : Majunbao
 * date : 2019/6/3 15:02
 * description :字符串判断
 */
public class StringUtils {

    public static boolean isEmpty(String str) {
        return (str == null || str.length() == 0);
    }

    /**
     * <p/>
     * to judge whether an object is empty <br>
     * 2014-10-23 2:41:59
     *
     * @param obj object to be tested
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(Object obj) {
        return null != obj;
    }

    /**
     * <p/>
     * checks if a string is empty <br>
     * 2014-10-232:46:18
     *
     * @param element the string to be tested
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(String element) {
        return null != element && !"".equals(element) && !"null".equals(element) && !"".equals(element.trim());
    }

    /**
     * <p/>
     * to judge whether a collection object is empty <br>
     * 2014-11-18 4:53:59
     *
     * @param list the collection object
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(Collection<?> list) {
        return null != list && list.size() > 0;
    }

    /**
     * <p/>
     * judge a map < k, v > set whether the object is empty <br>
     * 2014-11-18 4:53:59
     *
     * @param map the collection object
     * @return true: no empty false: empty
     */
    public static boolean isNotEmpty(Map<?, ?> map) {
        return null != map && map.size() > 0;
    }

    /**
     * Indicates whether the specified string is a digit
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        if (isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * @param parameter 参数
     * @return 格式化后的参数
     * @throws PatternSyntaxException
     */
    public static String stringAndNumberFilter(String parameter) throws PatternSyntaxException {
        String regEx = "[^a-zA-Z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(parameter);
        return m.replaceAll("").trim();
    }

    /**
     * @param parameter 参数
     * @return 格式化后的参数
     * @throws PatternSyntaxException
     */
    public static String stringFilter(String parameter) throws PatternSyntaxException {
        String regEx = "[^a-zA-Z]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(parameter);
        return m.replaceAll("").trim();
    }

    /**
     * @param parameter 参数
     * @return 格式化后的参数
     * @throws PatternSyntaxException
     */
    public static String numberFilter(String parameter) throws PatternSyntaxException {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(parameter);
        return m.replaceAll("").trim();
    }

    /**
     * @param parameter 参数
     * @return 格式化后的参数
     * @throws PatternSyntaxException
     */
    public static boolean payPasswordFilter(String parameter) throws PatternSyntaxException {
        String regEx = "^[1-9]{1}[0-9]{5}$";
        boolean result = Pattern.matches(regEx, parameter);
        return result;
    }

    /**
     * @param parameter 参数
     * @return 格式化后的参数
     * @throws PatternSyntaxException
     */
    public static boolean phoneFilter(String parameter) throws PatternSyntaxException {
        //String regEx = "^1[3|5|7|8|][0-9]{9}$";
        String regEx = "^1[1|2|3|4|5|6|7|8|9|][0-9]{9}$";
        //String regEx = "^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$";
        boolean result = Pattern.matches(regEx, parameter);
        return result;
    }

    /**
     * 检测密码长度{6,20},且同时需包含数字和字符
     *
     * @param parameter 参数
     * @return 格式化后的参数
     * @throws PatternSyntaxException
     */
    public static boolean passwordFilter(String parameter) throws PatternSyntaxException {
        //String regEx = "^[0-9]{6,20}$";
        String regStr = "(?=.*?[0-9])[a-zA-Z0-9]{6,20}$";
        //boolean result = Pattern.matches(regEx, parameter);
        boolean resultStr = Pattern.matches(regStr, parameter);
//        if (result) {
//            return false;
//        }
        return resultStr;
    }

    public static String seconds2Minute(String seconds) {
        try {
            int second = Integer.parseInt(seconds);
            if (second < 60) {
                return "00:" + String.format("%02d", second);
            } else if (second >= 60) {
                return String.format("%02d", second / 60) + ":" + String.format("%02d", second % 60);
            }
        } catch (Exception e) {
            return "00:00";
        }
        return "00:00";
    }
}
