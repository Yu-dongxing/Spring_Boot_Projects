package com.yuxs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
//public class BigEventApplication
//{
//    public static void main( String[] args )
//    {
//        SpringApplication.run(BigEventApplication.class,args);
//    }
//}
@SpringBootApplication
@MapperScan("com.yuxs.mapper")
public class BigEventApplication {
    public static void main(String[] args) {
        SpringApplication.run(BigEventApplication.class, args);
    }
}
