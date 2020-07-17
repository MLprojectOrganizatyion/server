package ci.microservice.notification.machineLearning.services;

import ci.microservice.notification.machineLearning.dao.AdresseMailRepository;
import ci.microservice.notification.machineLearning.models.Modelml;
import ci.microservice.notification.amqp.Prediction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AdresseMailServiceImpl implements AdresseMailService {
    @Autowired
    AdresseMailRepository adresseMailRepository;


    @Override
    public Prediction getPrediction(final Prediction prediction) {
        return prediction;
    }


    @Override
    public Modelml addModel(Modelml modelml) {
        Modelml adresse = new Modelml(modelml.getId());
        return adresse;
    }


}
