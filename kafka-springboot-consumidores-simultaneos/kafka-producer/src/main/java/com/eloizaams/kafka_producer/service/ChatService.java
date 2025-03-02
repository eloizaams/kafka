package com.eloizaams.kafka_producer.service;

import com.eloizaams.kafka_producer.dto.ChatMessageDTO;
import com.eloizaams.kafka_producer.producer.ChatRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    @Autowired
    private ChatRequestProducer chatRequestProducer;

    public String integrarChat(ChatMessageDTO chatMessage) {
        try {
            return chatRequestProducer.sendMessage(chatMessage);
        } catch (JsonProcessingException e) {
            return "Houve um erro ao enviar a mensagem: " + e.getMessage();
        }
    }
}
