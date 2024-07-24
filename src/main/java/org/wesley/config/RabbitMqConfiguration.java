package org.wesley.config;

import org.springframework.amqp.core.*;
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
    public Queue criarFilaPropostaPendenteMsNotificacao() {
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
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) { //Criando novo Rabbit admin passando Connection Factory (Spring inicializa automáticamente) como argumento
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializarAdmin(RabbitAdmin rabbitAdmin) { //Inicializando Rabbit admin criado anteriormente
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public FanoutExchange criarFanoutExchangePropostaPendente() { //Criando exchange responsável por distribuir as mensagens para o microserviço de análise de crédito e para o microserviço de notificação
        return ExchangeBuilder.fanoutExchange("proposta-pendente.ex").build();
    }

    @Bean
    public Binding criarBindingPropostaPendenteMsAnaliseCredito() {
        return BindingBuilder.bind(criarFilaPropostaPendenteMsAnaliseCredito())
                .to(criarFanoutExchangePropostaPendente());
    }

    @Bean
    public Binding criarBindingPropostaPendenteMsNotificacao() {
        return BindingBuilder.bind(criarFilaPropostaPendenteMsNotificacao())
                .to(criarFanoutExchangePropostaPendente());
    }
}
