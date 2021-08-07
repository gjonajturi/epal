package org.epal.client_service.client;

import org.epal.commons.transport.model.Bus;
import org.epal.commons.transport.model.BusLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * //same name as spring.application.name=transport-service
 * Spring automatically creates impl of TransportServiceClient & implements it
 */
@FeignClient(name="transport-service")
public interface TransportServiceClient {

    //======================== Bus ====================================
    //Same with methods on transport-service controllers,to interact with them
    @GetMapping("/api/bus")
    @ResponseStatus(HttpStatus.OK)
    List<Bus> findAllBuses();

    @PostMapping("/api/bus")
    @ResponseStatus(HttpStatus.CREATED)
    void saveBus(@RequestBody Bus newBus);

    @GetMapping("/api/bus/duty/{id}")
    @ResponseStatus(HttpStatus.OK)
    Boolean isInDuty(@PathVariable Long id);



    //=========================== Bus lines =======================================
    @GetMapping("/api/bus_line")
    @ResponseStatus(HttpStatus.OK)
    List<BusLine> findAllBusLines();

    @GetMapping("/api/bus_line/{busLineId}")
    @ResponseStatus(HttpStatus.OK)
    BusLine findBusLineById(@PathVariable Long busLineId);


}
