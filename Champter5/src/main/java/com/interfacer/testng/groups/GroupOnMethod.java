package com.interfacer.testng.groups;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class GroupOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1111");
    }


    @Test(groups = "client")
    public void test3(){
        System.out.println("这是服务端组的测试方法3333");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2222");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("服务端server组开始运行了");
    }

    @BeforeGroups("client")
    public void afterGroupOnSrver(){
        System.out.println("客户端组client组开始运行了");
    }
}
