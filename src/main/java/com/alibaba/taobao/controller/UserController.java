package com.alibaba.taobao.controller;

import com.alibaba.taobao.common.ApiRestResponse;
import com.alibaba.taobao.exception.AlibabaTaobaoException;
import com.alibaba.taobao.exception.AlibabaTaobaoExceptionEnum;
import com.alibaba.taobao.model.dao.User;
import com.alibaba.taobao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 描述：用户控制器
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public User personalPage() {
        return userService.getUser();
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse register(@RequestParam("username") String username, @RequestParam("password") String password) throws AlibabaTaobaoException {
        if (StringUtils.isEmpty(username)) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.NEED_USERNAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.NEED_PASSWORD);
        }
        // 密码长度不能少于8位
        if (password.length() < 8) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.PASSWORD_TOO_SHORT);
        }
        userService.register(username, password);
        return ApiRestResponse.success();
    }
}
