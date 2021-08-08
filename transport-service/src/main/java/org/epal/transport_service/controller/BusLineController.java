package org.epal.transport_service.controller;


import lombok.extern.slf4j.Slf4j;
import org.epal.commons.transport.model.BusLine;
import org.epal.transport_service.service.BusLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus_line")
@Slf4j
public class BusLineController {

    @Autowired
    private BusLineService busLineService;

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BusLine> findAll() {
        return busLineService.findAll();
    }

    @GetMapping("/{busLineId}")
    @ResponseStatus(HttpStatus.OK)
    public BusLine findById(@PathVariable Long busLineId) {
        BusLine busLine = busLineService.findById(busLineId)
                .orElseThrow(() -> new RuntimeException("BusLine with id " + busLineId + " not found."));

        log.info("Sending Bus line "+busLineId+" details to notification-service.");
        streamBridge.send("notificationEventSupplier-out-0", MessageBuilder.withPayload(busLineId).build());

        return busLine;
    }

}
