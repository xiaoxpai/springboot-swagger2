package com.xiaolh.swagger2.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Create by 肖橙橙
 * Date: 2020:08:04  01:00
 *
 * 1、模拟get请求
 * 2、模拟get请求返回cookie
 * 3、模拟get请求携带cookie信息
 * 4、模拟get请求携带参数
 * 5、模拟get请求携带参数二
 */
@RestController
@Api(value = "/",description = "get请求接口")
public class GetController {

    //1、模拟get请求
//    @RequestMapping(value = "/api/get",method = RequestMethod.GET)
    @ApiOperation(value = "模拟get请求",httpMethod = "GET")
    @GetMapping("/api/get")
    public String get(){
        return "返回的结果";
    }

    //2、模拟get请求返回cookie
//    @RequestMapping(value = "/api/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "模拟get请求返回cookie",httpMethod = "GET")
    @GetMapping("/api/getCookies")
    public String getCookies(HttpServletResponse response){
        Cookie cookie = new Cookie("luyi", "true");
        response.addCookie(cookie);
        return "请求返回的cookie";
    }


    //3、模拟get请求携带cookie信息
//    @RequestMapping(value = "/api/getwithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "模拟get请求携带cookie信息",httpMethod = "GET")
    @GetMapping("/api/getwithCookies")
    public String getwithCookies(HttpServletRequest request){
        //从get请求携带的cookie中获取cookie，并赋值给cookies数组
        Cookie[] cookies = request.getCookies();
        //判断cookies数组是否为空，如果为空返回错误，
        if(Objects.isNull(cookies)){
            return "必须携带cookie信息";
        }

        for (Cookie cookie : cookies ) {
            //不为空判断cookies是不是获取到的cookies
            if (cookie.getName().equals("login") && cookie.getValue().equals("true") ){
                return "携带cookie的get请求";
            }
        }
        return "cookie信息校验失败！";
    }

    //4、模拟get请求携带参数
//    @RequestMapping(value = "/api/getwithCookies",method = RequestMethod.GET)
    @ApiOperation(value = "模拟get请求携带参数",httpMethod = "GET")
    @GetMapping("/api/getParam")
    public Map<String,Object> getParam(
            @RequestParam("user_id") String userId,
            @RequestParam("user_ame") String userName
    ){
        Map<String, Object> repData = new HashMap<>();
        repData.put("user_id",userId);
        repData.put("user_ame",userName);
        return repData;
    }

    //5、模拟get请求携带参数二
//    @RequestMapping(value = "/api/getwithCookies/{userId}/{userName}",method = RequestMethod.GET)
    @ApiOperation(value = "模拟get请求携带参数二",httpMethod = "GET")
    @GetMapping("/api/getParams/{userId}/{userName}")
    public Map<String,Object> getParams(
            @PathVariable("userId") String userId,
            @PathVariable("userName") String userName
    ){
        Map<String, Object> repData = new HashMap<>();
        repData.put("userId",userId);
        repData.put("userName",userName);
        return repData;
    }
}
