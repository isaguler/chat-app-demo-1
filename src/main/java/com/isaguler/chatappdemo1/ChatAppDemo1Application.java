package com.isaguler.chatappdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ChatAppDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppDemo1Application.class, args);
	}

}
