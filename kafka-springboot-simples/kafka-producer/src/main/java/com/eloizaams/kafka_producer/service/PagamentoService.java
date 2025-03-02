package com.eloizaams.kafka_producer.service;

import com.eloizaams.kafka_producer.dto.PagamentoDTO;
import com.eloizaams.kafka_producer.producer.PagamentoRequestProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    @Autowired
    private PagamentoRequestProducer pagamentoRequestProducer;

    public String integrarPagamento(PagamentoDTO pagamentoDTO) {
        try {
            return pagamentoRequestProducer.sendMessage(pagamentoDTO);
        } catch (JsonProcessingException e) {
            return "Houve ume erro ao solicitar pagamento" + e.getMessage();
        }
    }
}
