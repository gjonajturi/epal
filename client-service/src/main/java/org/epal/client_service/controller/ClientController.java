package org.epal.client_service.controller;

import org.epal.client_service.client.TransportServiceClient;
import org.epal.client_service.dto.FavBusLineDto;
import org.epal.client_service.repository.FavBusLineRepository;
import org.epal.client_service.service.ClientService;
import org.epal.commons.client.model.Client;
import org.epal.commons.client.model.FavBusLine;
import org.epal.commons.transport.model.BusLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/client")
public class ClientController {


    @Autowired
    private ClientService clientService;

    @Autowired
    private FavBusLineRepository favBusLineRepository;

    @Autowired
    private TransportServiceClient transportServiceClient;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAll() {
        return clientService.findAll();
    }


    @PostMapping("/fav_bus_line")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveFavBusLine(@RequestBody FavBusLineDto favBusLineDto){
         FavBusLine favBusLine=new FavBusLine(null,favBusLineDto.getClientId(),favBusLineDto.getBusLineId());
         favBusLine=favBusLineRepository.saveAndFlush(favBusLine);
         return favBusLine.getId();
     }

    @GetMapping("/{clientId}/bus_line")
    @ResponseStatus(HttpStatus.OK)
    public BusLine findClientBusLine(@PathVariable Long clientId, @PathVariable Long busLineId){
       return transportServiceClient.findBusLineById(busLineId);
    }



}
