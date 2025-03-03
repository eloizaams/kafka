package com.eloizaams.kafka_consumer.kafka_consumer.consumidor;


import com.eloizaams.kafka_consumer.kafka_consumer.dto.ChatMessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class ChatConsumer {

    @Autowired
    private ObjectMapper objectMapper;


    @KafkaListener(
            topics = "${topicos.chat.request.topic}",
            groupId = "chat-consumer-unico"
    )
    public void consume(String message) throws JsonProcessingException {
        System.out.println("KAFKA CONS 2 ================ " + new Date());
        ChatMessageDto messageDto = objectMapper.readValue(message,ChatMessageDto.class);
        String messageTemplate = "DE: %s, PARA: %s \nTÍTULO: %s\nCONTEÚDO: %s";
        System.out.printf(
                messageTemplate,
                messageDto.getDe(),
                messageDto.getPara(),
                messageDto.getTitulo(),
                messageDto.getConteudo()
        );
        System.out.println("\n=============================");
    }
}
