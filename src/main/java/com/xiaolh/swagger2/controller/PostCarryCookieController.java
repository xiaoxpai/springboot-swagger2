package com.xiaolh.swagger2.controller;

import com.xiaolh.swagger2.entity.Account;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by 肖橙橙
 * Date: 2020:08:04  01:47
 *  7.模拟post请求携带cookies信息
 */

@RestController
@Api(value = "/",description = "post请求接口")
public class PostCarryCookieController {

    //定义cookie全局变量，供需要携带cookie的接口使用
    Cookie cookie;

    //定义一个login的post方法，然后返回cookie信息
    @PostMapping("/api/postlogin")
    @ApiOperation(value = "登录接口返回cookie信息", httpMethod = "POST")
    public String login(HttpServletResponse response,
                        @RequestParam("account")String account,
                        @RequestParam("password")String password
    ){
        //如果用户名和密码成功，就添加cookie信息，然后添加到response中，然后成功信息
        if ( account.equals("luyi") && password.equals("123")){
            cookie = new Cookie("token","123456789");
            response.addCookie(cookie);
            return "返回cookie，登录成功~";
        }
        return "success";
    }

    //创建account对象，getaccount接口会用到该对象创建用户登录信息。
    Account account;
    //用postman请求Login接口，会自动存储cookie，再请求getaccount接口时会自动把cookie带上，所以请求时不需要再单独处理cookie
    //携带cookie信息请求接口，同时返回用户列表的post接口
    @ApiOperation(value = "携带cookie信息请求接口，同时返回用户列表的post接口", httpMethod = "POST")
    public Account getAccount(HttpServletRequest request, @RequestBody Account account){

        //上一个接口返回的cookie，本接口去获取
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies ) {
            if ( cookie.getName().equals("token") &&  cookie.getValue().equals("123456789")
                && account.getName().equals("luyi") && account.getPassword().equals("123")){
                //接口的请求参数是getName和getPassword
                //接口的返回参数是getName、getPassword、
                //请求和返回的格式都是json
                //给user类中的属性赋值并返回
                account = new Account();
                account.setName("wenbing");
                account.setPassword("wenbing@123");
                return account;
            }
        }
        return null;
    }


}
