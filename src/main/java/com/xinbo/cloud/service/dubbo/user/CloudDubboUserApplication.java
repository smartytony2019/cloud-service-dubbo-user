package com.xinbo.cloud.service.dubbo.user;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


/**
 * @author 熊二
 * @date 2020/4/2 21:15
 * @desc file desc
 */

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "com.xinbo.cloud.common.mapper")
public class CloudDubboUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudDubboUserApplication.class, args);
    }
}
