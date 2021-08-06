package org.epal.client_service.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FavBusLineDto {

    private Long clientId;
    private Long busLineId;

}
