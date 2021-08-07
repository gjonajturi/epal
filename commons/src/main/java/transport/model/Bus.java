package transport.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@Document(value = "bus")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bus implements Serializable {

    @Id
    private Long id;
    private String plate;
    private String brand;


}
