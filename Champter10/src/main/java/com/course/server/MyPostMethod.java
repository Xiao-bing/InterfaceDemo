package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/",description ="这是我的全部的post请求接口" )
@RequestMapping("/v1")
public class MyPostMethod {
    //这个变量是用来存储我们的cookie信息的
    private static Cookie cookie;

    /**
     * 用户登录成功获取到cookies，然后再访问其他接口获取到列表
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口，成功后，获取cookies信息",httpMethod ="POST")//此标签用于描述方法
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName",required = true) String userName,
                        @RequestParam(value = "password",required = true) String password){
        if (userName.equals("xiaobing")&&password.equals("123456")){
            cookie = new Cookie("login","true");
            response.addCookie(cookie);
            return "恭喜您登录成功";
        }
        return "用户名或密码错误";
    }


    }


