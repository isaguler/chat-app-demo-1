package com.isaguler.chatappdemo1.service;

import com.isaguler.chatappdemo1.model.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void sendToChat(MessageDTO messageDTO) {
        messagingTemplate.convertAndSend("/topic" ,messageDTO);
    }
}
