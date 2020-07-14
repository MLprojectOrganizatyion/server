package ci.microservice.notification.adresseMail.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@ToString
public class Modelml {

    String id;

    public Modelml(@JsonProperty("id") String id) {
        this.id = id;
    }
//    public Modelml(Integer id) {
//        this.id = id;
//
//    }
}
