package ci.microservice.notification.amqp;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class EventModel {

    private String id;

    public EventModel(@JsonProperty("id") String id) {
        this.id = id;

    }
}


