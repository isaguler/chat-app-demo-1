package com.isaguler.chatappdemo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

@SpringBootApplication
@EnableKafka
@EnableWebSocketMessageBroker
public class ChatAppDemo1Application {

	public static void main(String[] args) {
		SpringApplication.run(ChatAppDemo1Application.class, args);
	}

}
