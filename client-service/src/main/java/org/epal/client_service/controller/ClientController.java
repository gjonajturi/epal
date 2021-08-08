package org.epal.client_service.controller;

import lombok.extern.slf4j.Slf4j;
import org.epal.client_service.client.TransportServiceClient;
import org.epal.client_service.dto.FavBusLineDto;
import org.epal.client_service.repository.FavBusLineRepository;
import org.epal.client_service.service.ClientService;
import org.epal.commons.client.model.Client;
import org.epal.commons.client.model.FavBusLine;
import org.epal.commons.transport.model.BusLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/client")
@Slf4j
public class ClientController {


    @Autowired
    private ClientService clientService;

    @Autowired
    private FavBusLineRepository favBusLineRepository;

    @Autowired
    private TransportServiceClient transportServiceClient;

    @Autowired
    private  Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private ExecutorService traceableExecutorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Client> findAll() {
        log.info("findAll mapping found.");
        return clientService.findAll();
    }


    @PostMapping("/fav_bus_line")
    @ResponseStatus(HttpStatus.CREATED)
    public Long saveFavBusLine(@RequestBody FavBusLineDto favBusLineDto){
        log.info("saveFavBusLine mapping found.");
         FavBusLine favBusLine=new FavBusLine(null,favBusLineDto.getClientId(),favBusLineDto.getBusLineId());
         favBusLine=favBusLineRepository.saveAndFlush(favBusLine);
         return favBusLine.getId();
     }

    @GetMapping("/{clientId}/bus_line/{busLineId}")
    @ResponseStatus(HttpStatus.OK)
    public BusLine findClientBusLine(@PathVariable Long clientId, @PathVariable Long busLineId){
        log.info("findClientBusLine mapping found");
        System.out.println("ClientId: "+clientId+"--BusLineId: "+busLineId);
       return transportServiceClient.findBusLineById(busLineId);
    }

    @GetMapping("/{clientId}/bus_line")
    @ResponseStatus(HttpStatus.OK)
    public List<BusLine> findAllBusLines(@PathVariable Long clientId){
        log.info("FindAllBusLines mapping found.");

        //Add to circuit breaker factory the traceable-executor-service to share request-id
        circuitBreakerFactory.configureExecutorService(traceableExecutorService);

        //Create new circuit breaker with circuit breaker factory
        Resilience4JCircuitBreaker circuitBreaker=circuitBreakerFactory.create("transport-circuit");

        Supplier<List<BusLine>> listSupplier=()->transportServiceClient.findAllBusLines();
        List<BusLine> busLines=circuitBreaker.run(listSupplier,throwable -> handleErrorCase());

        if(busLines!=null) {
            System.out.println("ClientId: " + clientId);
            return busLines;
        }else{
            System.err.println("ClientId : "+clientId);
            return busLines;
        }
    }

    private List<BusLine> handleErrorCase(){
        return null;
    }



}
