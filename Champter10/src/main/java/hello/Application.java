package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 一般类名是application的，基本上都是入口类
 * */
@SpringBootApplication
@ComponentScan("com.course")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
