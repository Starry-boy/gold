package com.jiaxc.gold.base;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/4/18 15:13
 */

@MapperScan("com.jiaxc.gold.base.**.mapper")
@EnableConfigurationProperties
@EnableTransactionManagement
@SpringBootApplication
public class GoldBaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoldBaseApplication.class, args);
    }
}
