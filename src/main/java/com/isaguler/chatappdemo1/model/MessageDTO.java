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

    private String timestamp;
}
