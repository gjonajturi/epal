package org.epal.transport_service.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@Document(value = "bus_line")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BusLine {
    @Id
    private Long id;
    private String name;
    private List<TransportCompany> transportCompanies;

}
