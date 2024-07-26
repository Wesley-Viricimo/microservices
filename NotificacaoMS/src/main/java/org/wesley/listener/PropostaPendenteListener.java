package org.wesley.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.wesley.constants.MensagemConstante;
import org.wesley.domain.Proposta;
import org.wesley.service.NotificacaoSmsService;

@Component
public class PropostaPendenteListener {

    private NotificacaoSmsService notificacaoSmsService;

    @RabbitListener(queues = "${rabbitmq.queue.proposta.pendente}") //Configuração para que o método seja um ouvinte da fila do nome informado
    public void propostaPendente(Proposta proposta) {
        String mensagem = String.format(MensagemConstante.PROPOSTA_EM_ANALISE, proposta.getUsuario().getNome());
        notificacaoSmsService.notificar(proposta.getUsuario().getTelefone(), mensagem);
    }
}
