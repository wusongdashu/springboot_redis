package com.bjsxt.controller;

import com.bjsxt.pojo.User;
import com.bjsxt.service.RedisService;
import com.bjsxt.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright (C) 2022
 * FileName: RedisTestController
 * Author: Mr.Wang
 * Date: 2022-09-01
 * Description: 注意这里的用户id在数据库里面是主键,key保持不同,非自动增长
 */
@Slf4j
@RestController
@RequestMapping("user")
public class RedisTestController {
    @Autowired
    private RedisService redisService;
    @Autowired
    private RedisUtil redisUtil;
    //key前缀
    public static final String str = "user:";

    @RequestMapping("add")
    public void add(@RequestBody User user) {

        if (!ObjectUtils.isEmpty(user)) {
            try {
                //存到数据库
                int i = redisService.add(user);
                //存储到redis
                redisUtil.set(str + user.getId(), user);
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e.getMessage());
            }
        }
    }

    @RequestMapping("getUsers")
    public User getUsers(@RequestParam("id") Integer id) {
        //先查询redis
        User use = (User) redisUtil.get(str + id);
        if (!ObjectUtils.isEmpty(use)) {
            return use;
        } else {
            User user = redisService.getUsers(id);
            return user;
        }
    }
}
