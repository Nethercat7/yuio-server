package com.zfy.yuio;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.zfy.yuio.dao")
public class YuioApplication {
	public static void main(String[] args) {
		SpringApplication.run(YuioApplication.class, args);
	}
}
