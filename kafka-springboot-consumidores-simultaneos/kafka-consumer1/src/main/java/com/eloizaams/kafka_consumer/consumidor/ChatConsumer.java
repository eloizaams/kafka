package com.eloizaams.kafka_consumer.consumidor;

import com.eloizaams.kafka_consumer.dto.ChatMessageDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;


//@Service
public class ChatConsumer {

//    @Autowired
    private ObjectMapper objectMapper;

//    @KafkaListener(
//            topics = "${topicos.chat.request.topic}",
//            groupId = "chat-consumer-unico"
//    )
    public void consume(String message) throws JsonProcessingException {
        System.out.println("KAFKA CONS 1 ================ " + new Date());
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
