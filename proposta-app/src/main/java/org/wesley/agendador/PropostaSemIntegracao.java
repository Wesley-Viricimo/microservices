package org.wesley.agendador;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.wesley.entity.Proposta;
import org.wesley.repository.PropostaRepository;
import org.wesley.service.NotificacaoRabbitService;

import java.util.concurrent.TimeUnit;

@Component
public class PropostaSemIntegracao {

    private final Logger logger = LoggerFactory.getLogger(PropostaSemIntegracao.class);

    @Autowired
    private PropostaRepository propostaRepository;

    @Autowired
    private NotificacaoRabbitService notificacaoRabbitService;

    @Value("${rabbitmq.propostapendente.exchange}")
    private String exchange;

    @Scheduled(fixedDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void buscarPropostaSemIntegracao() {
        propostaRepository.findAllByIntegradaIsFalse().forEach( proposta -> {
            try {
                notificacaoRabbitService.notificar(proposta, exchange);
                atualizarProposta(proposta);
            } catch (RuntimeException e) {
                logger.error(e.getMessage());
            }
        });
    }

    private void atualizarProposta(Proposta proposta) {
        proposta.setIntegrada(true);
        propostaRepository.save(proposta);
    }
}
