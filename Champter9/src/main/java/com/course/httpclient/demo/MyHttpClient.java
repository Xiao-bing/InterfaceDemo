package com.course.httpclient.demo;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;
import java.io.IOException;

public class MyHttpClient {
    @Test
    public void test1() throws IOException {
        //用来存储我们的结果
        String result;
        HttpGet get = new HttpGet("http://www.baidu.com");
        //用来执行get方法
        HttpClient client = new DefaultHttpClient();
        //因为execute返回的的是HttpResponse，所以使用httpresponse接收返回信息
        HttpResponse response = client.execute(get);
        //将接收到的内容转换成字符串
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);
    }
}
