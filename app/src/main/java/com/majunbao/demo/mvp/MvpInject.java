package com.majunbao.demo.mvp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *    author : Majunbao
 *    github : https://github.com/MaJunBaox
 *    time   : 2019/05/11
 *    desc   : Mvp 实例化注解
 */
@Target(ElementType.FIELD) // 字段注解
@Retention(RetentionPolicy.RUNTIME) // 运行时注解
public @interface MvpInject {}