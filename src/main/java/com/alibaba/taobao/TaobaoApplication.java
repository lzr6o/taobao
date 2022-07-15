package com.alibaba.taobao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TaobaoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaobaoApplication.class, args);
    }

}
