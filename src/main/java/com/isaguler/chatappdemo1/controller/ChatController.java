package com.isaguler.chatappdemo1.controller;

import com.isaguler.chatappdemo1.model.MessageDTO;
import com.isaguler.chatappdemo1.service.ChatService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/sendMessage")
    public void sendMessage(@RequestBody MessageDTO messageDTO) {
        chatService.sendMessageViaApiAndKafka(messageDTO);
    }

    @MessageMapping("/chat")
    public void chatEndpoint(@Payload MessageDTO messageDTO) {
        chatService.sendToChat(messageDTO);
    }
}
