package com.alibaba.taobao.controller;

import com.alibaba.taobao.common.ApiRestResponse;
import com.alibaba.taobao.common.Constant;
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

import javax.servlet.http.HttpSession;

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

    @PostMapping("/login")
    @ResponseBody
    public ApiRestResponse login(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session) throws AlibabaTaobaoException {
        if (StringUtils.isEmpty(username)) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.NEED_USERNAME);
        }
        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.NEED_PASSWORD);
        }
        User user = userService.login(username, password);
        // 保存用户信息时，不保存密码
        user.setPassword(null);
        session.setAttribute(Constant.ALIBABA_TAOBAO_USER, user);
        return ApiRestResponse.success(user);
    }

    @PostMapping("/user/update")
    @ResponseBody
    public ApiRestResponse updateUserInfo(HttpSession session, @RequestParam String signature) throws AlibabaTaobaoException {
        User currentUser = (User) session.getAttribute(Constant.ALIBABA_TAOBAO_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(AlibabaTaobaoExceptionEnum.NEED_LOGIN);
        }
        User user = new User();
        user.setId(currentUser.getId());
        user.setPersonalizedSignature(signature);
        userService.updateInformation(user);
        return ApiRestResponse.success();
    }
}
