package org.wesley.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wesley.dto.PropostaResponseDTO;
import org.wesley.entity.Proposta;

@Service
public class NotificacaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void notificar(Proposta proposta, String exchange) {
        rabbitTemplate.convertAndSend(exchange, "", proposta);
    }
}
