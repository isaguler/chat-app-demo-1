package com.isaguler.chatappdemo1.service;

import com.google.gson.Gson;
import com.isaguler.chatappdemo1.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ChatListener {

    Gson gson = new Gson();

    @Autowired
    private ChatService chatService;

    @KafkaListener(groupId = "chat", topics = "chat-demo")
    public void kafkaListener(String message) {
        System.out.println("message is: " + message);

        MessageDTO messageDTO = gson.fromJson(message, MessageDTO.class);

        System.out.println(messageDTO.getContent());

        chatService.sendToChat(messageDTO);
    }
}
