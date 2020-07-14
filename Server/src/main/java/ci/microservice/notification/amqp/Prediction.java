package ci.microservice.notification.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@ToString
public class Prediction {

    private String traffic_30;
    private String traffic_50;
    private String traffic_60;
//    public Prediction(String traffic_30,
//                      String traffic_50,
//                     String traffic_60) {
//        this.traffic_30 = traffic_30;
//        this.traffic_50 = traffic_50;
//        this.traffic_60 = traffic_60;
//    }
//}
    public Prediction(@JsonProperty("traffic_30") String traffic_30,
                      @JsonProperty("traffic_50") String traffic_50,
                      @JsonProperty("traffic_60") String traffic_60) {
        this.traffic_30 = traffic_30;
        this.traffic_50 = traffic_50;
        this.traffic_60 = traffic_60;}
  }

