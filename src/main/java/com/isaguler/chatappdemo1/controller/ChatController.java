package com.isaguler.chatappdemo1.controller;

import com.isaguler.chatappdemo1.model.MessageDTO;
import com.isaguler.chatappdemo1.service.ChatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@Slf4j
@CrossOrigin
public class ChatController {

    @Autowired
    private KafkaTemplate<String, MessageDTO> messageDTOKafkaTemplate;

    @Autowired
    private ChatService chatService;

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
        messageDTO.setTimestamp(LocalDateTime.now().toString());

        try {
            messageDTOKafkaTemplate.send("chat-demo", messageDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @MessageMapping("/chat")
    public void chatEndpoint(@Payload MessageDTO messageDTO) {
        messageDTO.setTimestamp(LocalDateTime.now().toString());

        chatService.sendToChat(messageDTO);
    }
}
