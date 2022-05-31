package com.alibaba.taobao.service.impl;

import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
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

    @Override
    public void register(String username, String password) throws AlibabaTaobaoException {
        // 查询用户名是否存在，不允许重名
        User result = userRepository.findByUsername(username);
        if (result != null) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.USERNAME_EXISTED);
        }
        // 写到数据库
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        int count =
    }
}
