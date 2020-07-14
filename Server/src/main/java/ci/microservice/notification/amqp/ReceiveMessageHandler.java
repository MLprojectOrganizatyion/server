//package ci.microservice.notification.amqp;
//
//        import lombok.extern.slf4j.Slf4j;
//        import org.springframework.amqp.rabbit.annotation.RabbitListener;
//        import org.springframework.stereotype.Service;
//
//@Service
//@Slf4j
//public class ReceiveMessageHandler {
//
//    @RabbitListener(queues = AmqpConfig.QUEUE_PREDICTION)
//    public void consumeDefaultMessage(final Prediction prediction) {
//        log.info("message receive: {}", prediction.toString());
//    }
//}
