package ci.microservice.notification.machineLearning.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

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
