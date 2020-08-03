package com.xiaolh.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by 肖橙橙
 * Date: 2020:08:04  01:20
 *
 * 6、模拟post请求返回cookies信息
 */

@RestController
@Api(value = "/",description = "post请求接口")
public class PostController {

    //定义cookie全局变量，供需要携带cookie的接口使用
    Cookie cookie;

    @RequestMapping(value = "/useSpringBoot/postlogin",method = RequestMethod.POST)
    @ApiOperation(value = "登录接口返回cookie信息",httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam("name") String name,
                        @RequestParam("password") String password
                        ){
        //如果用户名和密码成功，则添加Cookie信息,添加到response中，返回成功信息
        if ( name.equals("luyi") && password.equals("luyi123")){
            cookie = new Cookie("token","123456789");
            response.addCookie(cookie);
            return "返回cookie，登录成功";
        }
        return "登录失败";
    }

    //7、模拟post请求携带cookies信息
    //以下代码中getusers方法就是携带cookies信息的post请求




}
