package com.example.bootweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
@EnableDiscoveryClient
//@ComponentScan(basePackages = {"com.jtl","com.example.bootweb"})
public class BootwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootwebApplication.class, args);
	}
}
