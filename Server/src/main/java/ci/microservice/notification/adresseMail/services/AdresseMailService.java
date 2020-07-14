package ci.microservice.notification.adresseMail.services;

import ci.microservice.notification.adresseMail.models.Modelml;
import ci.microservice.notification.amqp.Prediction;

import java.util.List;


public interface AdresseMailService {
    Prediction getPrediction(final Prediction prediction);
    Modelml addModel(Modelml modelml);
}
