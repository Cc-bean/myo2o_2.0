package com.yyc.o2o;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class O2oApplication extends SpringBootServletInitializer {
    //配置负责初始化Spring应用上下文的监听器作用类似
   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(O2oApplication.class);
    }*/

    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }

}
/*
@SpringBootApplication
public class O2oApplication {

    public static void main(String[] args) {
        SpringApplication.run(O2oApplication.class, args);
    }
}
*/

