package com.alibaba.taobao.service;

import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.model.dao.User;

/**
 * 描述: UserService
 */
public interface UserService {
    User getUser();

    void register(String username, String password) throws AlibabaTaobaoException;

    User login(String username, String password) throws AlibabaTaobaoException;

    void updateInformation(User user) throws AlibabaTaobaoException;
}
