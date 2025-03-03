package com.eloizaams.kafka_producer.producer;

import com.eloizaams.kafka_producer.dto.ChatMessageDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatRequestProducer {

    @Value("${topicos.chat.request.topic}")
    private String chatRequestTopic;

    @Value("${topicos.chat.request.topic2}")
    private String chatRequestTopic2;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(ChatMessageDTO message) throws JsonProcessingException {
        String conteudo = objectMapper.writeValueAsString(message);
        kafkaTemplate.send(chatRequestTopic, conteudo);
        kafkaTemplate.send(chatRequestTopic2, conteudo);
        return "Mensagem enviada para processamento";
    }
}
