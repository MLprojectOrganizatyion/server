package ci.microservice.notification.amqp;


//import org.springframework.amqp.core.*;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;

import java.util.logging.Logger;

@Configuration
@EnableRabbit
public class AmqpConfig {

    public static final String QUEUE_SEND_MODEL = "send_model_queue";
    public static final String QUEUE_PREDICTION = "prediction_queue";

    @Bean(name = "connexion")
    public ConnectionFactory createConnectionFactory() {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("chinook.rmq.cloudamqp.com");
        connectionFactory.setUsername("chfcmcko");
        connectionFactory.setPassword("Q6-goXluL-7715xQIehznVetJ3RoNtvj");
        connectionFactory.setVirtualHost("chfcmcko");
        return connectionFactory;
    }


    @Bean
    public RabbitAdmin createAdmin() {
        ConnectionFactory ConnectionFactory = createConnectionFactory();
        RabbitAdmin admin = new RabbitAdmin(ConnectionFactory);

        return admin;
    }


    @Bean
    Queue createQueueSendModel() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(QUEUE_SEND_MODEL, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }

    @Bean
    Queue createQueueReciecePrediction() {
        RabbitAdmin admin = createAdmin();
        Queue queue = new Queue(QUEUE_PREDICTION, true, false, false);
        admin.declareQueue(queue);
        return queue;
    }
    @Bean
    public Jackson2JsonMessageConverter producerMessage()
    {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(@Qualifier("connexion") final ConnectionFactory connectionFactory)
    {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerMessage());
        return rabbitTemplate;
    }

}

































//        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
//        //connectionFactory.setUri("http://localhost/");
//        connectionFactory.setHost("localhost");
//        //connectionFactory.setHost();
//        connectionFactory.setUsername("guest");
//        connectionFactory.setPassword("guest");
//        //connectionFactory.setPort(15672);
//        //connectionFactory.setVirtualHost("fhnnluqg");

//
//
//    @Bean
//    public Jackson2JsonMessageConverter producerMessage() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//    @Bean
//    public RabbitTemplate rabbitTemplate(@Qualifier("connexion") final ConnectionFactory connectionFactory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(producerMessage());
//        return rabbitTemplate;
//    }

//**************************************************************************************************************//
//    @Bean
//    TopicExchange exchange(){
//        TopicExchange exchange = new TopicExchange(EXCHANGE_NAME);
//        RabbitAdmin admin = createAdmin();
//        admin.declareExchange(exchange);
//        return exchange;
//    }
//
//    @Bean
//    Binding binding(Queue q, TopicExchange exchange){
//        RabbitAdmin admin = createAdmin();
//        admin.declareBinding(BindingBuilder.bind(q).to(exchange).with("mike.#"));
//        return BindingBuilder.bind(q).to(exchange).with("mike.#");
//    }

  /*  @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory
            , MessageListenerAdapter messageListenerAdapter){
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(QUEUE_NAME);
        container.setMessageListener(messageListenerAdapter);
        return container;
    }*/


/*
    @Bean
    MessageListenerAdapter listenerAdapter(ReceiveMessageHandler handler){
        return new MessageListenerAdapter(handler, "handleMessage");
    }
*/



























/*public static  final String AUTH_QUEUE = "auth-queue";
    public static  final String AUTH_EXCHANGE = "auth-exchange";
    @Bean
    Queue authQueue(){
        return QueueBuilder
                .durable("AUTH_QUEUE")
                .build();

    }


    @Bean
    TopicExchange authExchange(){
        return  new TopicExchange(AUTH_EXCHANGE);
    }

    @Bean
    Binding authBinding(){
        return BindingBuilder.bind(authQueue()).to(authExchange()).with("#");
    }*/
