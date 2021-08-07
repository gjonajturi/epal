package transport.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@Document(value = "transport_company")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransportCompany {

    @Id
    private Long id;
    private String code;
    private String name;

}
