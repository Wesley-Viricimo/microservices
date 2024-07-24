package org.wesley.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    @Bean
    public Queue criarFilaPropostaPendenteMsAnaliseCredito() {
        return QueueBuilder.durable("proposta-pendente.ms-analise-credito").build(); //Cria uma fila do tipo durável, ou seja, caso o RabbitMQ caia, as mensagens continuarão salvas
    }

    @Bean
    public Queue criarFilaMsNotificacao() {
        return QueueBuilder.durable("proposta-pendente.ms-notificacao").build(); //Cria uma fila do tipo durável, ou seja, caso o RabbitMQ caia, as mensagens continuarão salvas
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsProposta() {
        return QueueBuilder.durable("proposta-concluida.ms-proposta").build(); //Cria uma fila do tipo durável, ou seja, caso o RabbitMQ caia, as mensagens continuarão salvas
    }

    @Bean
    public Queue criarFilaPropostaConcluidaMsNotificacao() {
        return QueueBuilder.durable("proposta-concluida.ms-notificacao").build(); //Cria uma fila do tipo durável, ou seja, caso o RabbitMQ caia, as mensagens continuarão salvas
    }

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }
}
