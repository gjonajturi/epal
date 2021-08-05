package org.epal.transport_service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Builder
@Document(value = "bus")
@AllArgsConstructor
@NoArgsConstructor
public class Bus implements Serializable {

    @Id
    private Long id;
    private String plate;
    private String brand;


}
