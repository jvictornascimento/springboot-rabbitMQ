package com.jvictornascimento.msnewsletter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsNewsletterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNewsletterApplication.class, args);
	}

}
