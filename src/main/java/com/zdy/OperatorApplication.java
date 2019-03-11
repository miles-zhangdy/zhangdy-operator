package com.zdy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.zdy.**.dao")//这一步是让mapper文件实现dao接口的
public class OperatorApplication extends SpringBootServletInitializer implements CommandLineRunner {


    public static void main(String[] args) {
        try {
            SpringApplication.run(OperatorApplication.class, args);
        } catch (Exception e) {

        }
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(OperatorApplication.class);
    }

    @Override
    public void run(String... strings) throws Exception {


    }
}
