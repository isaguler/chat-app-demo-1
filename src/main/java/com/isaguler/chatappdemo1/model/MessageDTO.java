package com.isaguler.chatappdemo1.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MessageDTO {

    private String sender;

    private String content;

    public static Message converter(MessageDTO messageDTO) {
        Message message = new Message();
        message.setUsername(messageDTO.getSender());
        message.setContent(messageDTO.getContent());

        return message;
    }
}
