package com.yuxs.utils;

public class ThreadLocalUtil {
    //提供Threadlocal对象
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();
    //根据键获取
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
    //存储键值对
    public static void set(Object value ){
        THREAD_LOCAL.set(value);

    }
    //清除threadLOcal 防止内存泄漏
    public static void remove (){
        THREAD_LOCAL.remove();
    }
}
