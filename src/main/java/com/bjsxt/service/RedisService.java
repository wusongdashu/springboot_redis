package com.bjsxt.service;

import com.bjsxt.pojo.User;

/**
 * Copyright (C) 2022
 * FileName: RedisService
 * Author: Mr.Wang
 * Date: 2022-09-01
 * Description:
 */
public interface RedisService {
    int add(User user);
    User getUsers(Integer id);
}
