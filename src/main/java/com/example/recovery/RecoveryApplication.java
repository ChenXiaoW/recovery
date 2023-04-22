package com.example.recovery;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@MapperScan(value = {"com.example.recovery.mapper"})
@EnableTransactionManagement //开启事务管理
@SpringBootApplication
public class RecoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecoveryApplication.class, args);
    }

}
