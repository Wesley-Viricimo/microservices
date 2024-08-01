package org.wesley.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Configuration;
import org.wesley.domain.Proposta;

@Configuration
public class PropostaEmAnaliseListener {

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}")
    public void propostaEmAnalise(Proposta proposta) {

    }
}
