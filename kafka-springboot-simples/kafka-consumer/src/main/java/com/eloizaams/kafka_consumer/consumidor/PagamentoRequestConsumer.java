package com.eloizaams.kafka_consumer.consumidor;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PagamentoRequestConsumer {

    @KafkaListener(
            topics = "${topicos.pagamento.request.topic}",
            groupId = "pagamento-request-conumer-1"
    )
    public void consume(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}
