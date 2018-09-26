package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value="/",description = "这是我的全部的get方法")//这个注解用于swagger调用接口
public class MyGetMethod {


    /**
     *服务器返回cookies给浏览器的get接口
     */
    @RequestMapping(value="/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到cookies",httpMethod ="GET")//此标签用于描述方法
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest请求信息类
        //httpServerletResponse响应信息类
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你，获取cookies信息成功";
    }

    /**
     *浏览器携带cookies信息发送请求的get接口
     */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies信息访问",httpMethod ="GET")//此标签用于描述接口
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        //判断cookies是否为空
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
             return "恭喜你，访问成功了！！！";
            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第一种实现方式：url？key=value&key=value
     * 我们来模拟获取商品列表的一个接口
     */
    @RequestMapping(value = "get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求的第一种实现",httpMethod ="GET")//此标签用于描述接口
    public Map<String,Integer>getList(@RequestParam Integer start,@RequestParam Integer end){
        Map<String,Integer>myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("方便面",1);
        myList.put("衣服",200);
        return myList;
    }

    /**
     * 开发一个需要携带参数才能访问的get请求
     * 第二种实现方式：url：ip+port+get/with/param/10/20
     */
    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get请求的第二种实现",httpMethod ="GET")//此标签用于描述接口
    public Map myGetList(@PathVariable Integer start,@PathVariable Integer end){
        Map<String,Integer>myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("方便面",1);
        myList.put("衣服",200);
        return myList;
    }
}

