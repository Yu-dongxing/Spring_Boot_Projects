package com.yuxs;
import org.junit.jupiter.api.Test;
public class ThreadLocalTest {
    @Test
    public void testThreadLocalTest(){
        ThreadLocal<String> tl = new ThreadLocal<>();
        new Thread(()->{
            tl.set("yuxs");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        },"aa").start();
        new Thread(()->{
            tl.set("yudongxing");
            System.out.println(Thread.currentThread().getName()+": "+tl.get());
        },"bb").start();
    }
}