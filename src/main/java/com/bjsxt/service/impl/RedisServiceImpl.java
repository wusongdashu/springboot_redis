package com.bjsxt.service.impl;

import com.bjsxt.mapper.RedisMapper;
import com.bjsxt.pojo.User;
import com.bjsxt.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (C) 2022
 * FileName: RedisServiceImpl
 * Author: Mr.Wang
 * Date: 2022-09-01
 * Description:
 */
@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private RedisMapper redisMapper;
    @Override
    public int add(User user) {
        return redisMapper.insert(user);
    }

    @Override
    public User getUsers(Integer id) {
        return redisMapper.selectByPrimaryKey(id);
    }
}
