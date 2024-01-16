package com.kitaplik.libraryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import com.kitaplik.libraryservice.client.RetreiveMessageErrorDecoder;

import feign.codec.ErrorDecoder;

@SpringBootApplication
@EnableFeignClients
public class LibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryServiceApplication.class, args);
	}

	@Bean
	public ErrorDecoder errorDecoder() {
		return new RetreiveMessageErrorDecoder();
		//feignden hata aldığımızda  eror decoder kontrolü ele alacak biz kend decoderimizi gösteriyoruz.
		//o decoder içinde bir exception firlatıyoruz , onunda general exceptiondan  yönetiyoruz
	}
}
