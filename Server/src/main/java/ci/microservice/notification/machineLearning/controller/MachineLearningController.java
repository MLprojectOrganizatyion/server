package ci.microservice.notification.machineLearning.controller;

import ci.microservice.notification.machineLearning.models.Modelml;
import ci.microservice.notification.machineLearning.services.AdresseMailService;
import ci.microservice.notification.amqp.AmqpConfig;
import ci.microservice.notification.amqp.Prediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Service
@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ml")
public class MachineLearningController {

    @Autowired
    AdresseMailService adresseMailService;
    private final RabbitTemplate rabbitTemplate;

    public MachineLearningController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    @CrossOrigin(origins="http://localhost:4200")
    @GetMapping("/test")
    public String sayGreeting() {
        return "Hello Mouna";

    }

    //@CrossOrigin
    @PostMapping("/model")
    public Modelml addAdresseMail(@RequestBody Modelml model) {

        rabbitTemplate.convertAndSend(AmqpConfig.QUEUE_SEND_MODEL, model);
        return adresseMailService.addModel(model);
    }

    @GetMapping("/predict")
    //@RabbitListener(queues = AmqpConfig.QUEUE_SEND_MODEL)
    public Object getPrediction() {
        Object prediction = rabbitTemplate.receiveAndConvert(AmqpConfig.QUEUE_PREDICTION);
        // Prediction prediction= (Prediction) rabbitTemplate.receiveAndConvert(AmqpConfig.QUEUE_PREDICTION);
        System.out.print("Prediction"+ prediction);
        // return (Prediction) rabbitTemplate.receiveAndConvert(AmqpConfig.QUEUE_PREDICTION);
        return prediction;
    }

//    @GetMapping("/predict")
//    //@RabbitListener(queues = AmqpConfig.QUEUE_SEND_MODEL)
//    public Prediction getPrediction() {
//        Prediction prediction= (Prediction) rabbitTemplate.receiveAndConvert(AmqpConfig.QUEUE_PREDICTION);
//        System.out.print("Prediction"+ prediction);
//       // return (Prediction) rabbitTemplate.receiveAndConvert(AmqpConfig.QUEUE_PREDICTION);
//        return prediction;
//    }
}
