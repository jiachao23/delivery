package com.delivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * @author jiac
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class })
public class DeliveryApplication{
	public static void main(String[] args) {
		SpringApplication.run(DeliveryApplication.class, args);
	}


}