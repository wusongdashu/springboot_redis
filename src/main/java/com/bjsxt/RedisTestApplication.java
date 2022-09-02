package com.bjsxt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * Copyright (C) 2022
 * FileName: com.bjsxt.RedisTestApplication
 * Author: Mr.Wang
 * Date: 2022-09-01
 * Description:
 */
@SpringBootApplication
@MapperScan("com.bjsxt.mapper")
public class RedisTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RedisTestApplication.class);
    }
}
