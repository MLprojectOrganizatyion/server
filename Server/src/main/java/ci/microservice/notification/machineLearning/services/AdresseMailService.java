package ci.microservice.notification.machineLearning.services;

import ci.microservice.notification.machineLearning.models.Modelml;
import ci.microservice.notification.amqp.Prediction;


public interface AdresseMailService {
    Prediction getPrediction(final Prediction prediction);
    Modelml addModel(Modelml modelml);
}
