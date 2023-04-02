package com.isaguler.chatappdemo1.service;

import com.isaguler.chatappdemo1.model.Message;
import com.isaguler.chatappdemo1.model.MessageDTO;
import com.isaguler.chatappdemo1.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ChatService {

    private final MessageRepository messageRepository;
    private final SimpMessagingTemplate messagingTemplate;
    private final KafkaTemplate<String, MessageDTO> messageDTOKafkaTemplate;

    public ChatService(MessageRepository messageRepository, SimpMessagingTemplate messagingTemplate, KafkaTemplate<String, MessageDTO> messageDTOKafkaTemplate) {
        this.messageRepository = messageRepository;
        this.messagingTemplate = messagingTemplate;
        this.messageDTOKafkaTemplate = messageDTOKafkaTemplate;
    }

    @MessageMapping("/chat")
    public void sendToChat(MessageDTO messageDTO) {
        messagingTemplate.convertAndSend("/topic" , messageDTO);

        Message savedMessage = this.saveMessage(messageDTO);
        log.info("sendToChat savedMessage: " + savedMessage);
    }

    public void sendMessageViaApiAndKafka(MessageDTO messageDTO) {
        try {
            messageDTOKafkaTemplate.send("chat-demo", messageDTO);

            Message savedMessage = this.saveMessage(messageDTO);
            log.info("sendMessageViaApiAndKafka savedMessage: " + savedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Message saveMessage(MessageDTO messageDTO) {
        return messageRepository.save(MessageDTO.converter(messageDTO));
    }
}
