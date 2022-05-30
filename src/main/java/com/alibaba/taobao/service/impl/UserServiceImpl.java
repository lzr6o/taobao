package com.alibaba.taobao.service.impl;

import com.alibaba.taobao.model.dao.User;
import com.alibaba.taobao.model.repository.UserRepository;
import com.alibaba.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser() {
        return userRepository.findById(1).get();
    }
}
