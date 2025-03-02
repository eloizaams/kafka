package com.eloizaams.kafka_producer.api;

import com.eloizaams.kafka_producer.dto.ChatMessageDTO;
import com.eloizaams.kafka_producer.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chat")
public class ChatAPI {
    @Autowired
    private ChatService chatService;

    @PostMapping
    public String enviarMensagem(@RequestBody ChatMessageDTO chatMessage) {
        return chatService.integrarChat(chatMessage);
    }
}
