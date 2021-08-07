package org.epal.transport_service.controller;

import org.epal.transport_service.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import transport.model.Bus;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Bus> findAll() {
        return busService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBus(@RequestBody Bus newBus) {
        busService.save(newBus);
    }

    @GetMapping("/duty/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Boolean isInDuty(@PathVariable Long id) {
        Bus bus = busService.findInDuty(id)
                .orElseThrow(() -> new RuntimeException("Bus with id " + id + " is not in duty"));
        return bus != null;
    }
}
