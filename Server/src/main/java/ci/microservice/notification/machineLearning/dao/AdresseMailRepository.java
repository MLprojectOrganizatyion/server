package ci.microservice.notification.machineLearning.dao;

import ci.microservice.notification.machineLearning.models.Modelml;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface AdresseMailRepository extends MongoRepository<Modelml, String> {


}