package com.alibaba.taobao.service.impl;

import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
import com.alibaba.taobao.model.dao.User;
import com.alibaba.taobao.model.repository.UserRepository;
import com.alibaba.taobao.service.UserService;
import com.alibaba.taobao.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

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
        try {
            user.setPassword(MD5Utils.getMD5Str(password));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        try {
            userRepository.save(user);
        } catch (Exception ex) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.INSERT_FAILED);
        }
    }

    @Override
    public User login(String username, String password) throws AlibabaTaobaoException {
        String md5Password = null;
        try {
            md5Password = MD5Utils.getMD5Str(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        User user = userRepository.selectLogin(username, md5Password);
        if (user == null) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.WRONG_PASSWORD);
        }
        return user;
    }

    @Override
    public void updateInformation(User user) throws AlibabaTaobaoException {
        // 更新个性签名
        int updateCount = userRepository.updateByPrimaryKeySelective(user);
        if (updateCount > 1) {
            throw new AlibabaTaobaoException(AlibabaTaobaoExceptionEnum.UPDATE_FAILED);
        }
    }
}
