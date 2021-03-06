package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    //从配置文件中获取url
    private String url;
    private ResourceBundle bundle;//用来读取配置文件
    //用来存储cookies信息的变量
    private CookieStore store;
    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }
    @Test
    public void testGetCookies() throws IOException {
        //拼接测试的url地址
        String result;
        String uri = bundle.getString("test.getCookies.uri");
        String testurl = this.url + uri;
        //访问
        HttpGet get = new HttpGet(testurl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        System.out.println(result);
        //获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie_name=" + name + "    cookie_value=" + value);
        }
    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMetnod() throws IOException {
        //拼接最终的测试地址
        String uri = bundle.getString("test.postwithcookies");
        String testUrl =this.url +uri;
        //声明一个client对象，进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //声明一个post方法
        HttpPost post = new HttpPost(testUrl);
        //添加json格式的参数
        JSONObject param = new JSONObject();
        param.put("name","xiaobing");
        param.put("age","20");
        //设置请求的头信息  设置header,如果有多个头信息，再次使用这个方法
        post.setHeader("content-type","application/json");
        //将参数添加到方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        //声明一个对象，进行响应结果的存储
        String result ;
        //设置cookie信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response =  client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
        //处理响应结果
        //1.将返回的结果字符串转化为json对象
        JSONObject resultJson = new JSONObject(result);
        //2.具体的判断返回结果的值
        String success = (String) resultJson.get("xiaobing");
        String status = (String) resultJson.get("status");
        //具体的判断返回结果的值
        Assert.assertEquals("success",success);//期望结果与实际结果做比对
        Assert.assertEquals("1",status);
    }
}
