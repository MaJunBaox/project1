package com.majunbao.demo.net.cookie;

/**
 * author : Majunbao
 * date : 2019/6/3 17:25
 * description :
 */
public class Exceptions
{
    public static void illegalArgument(String msg, Object... params)
    {
        throw new IllegalArgumentException(String.format(msg, params));
    }


}
