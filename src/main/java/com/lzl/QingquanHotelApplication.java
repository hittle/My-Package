package com.lzl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(value="com.lzl.mapper")
@SpringBootApplication
public class QingquanHotelApplication {

    public static void main(String[] args) {
        SpringApplication.run(QingquanHotelApplication.class, args);
    }

}
