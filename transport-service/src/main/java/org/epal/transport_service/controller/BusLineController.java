package org.epal.transport_service.controller;


import org.epal.commons.tranport.model.BusLine;
import org.epal.transport_service.service.BusLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus_line")
public class BusLineController {

    @Autowired
    private BusLineService busLineService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BusLine> findAll() {
        return busLineService.findAll();
    }

    @GetMapping("/{busLineId}")
    @ResponseStatus(HttpStatus.OK)
    public BusLine findById(@PathVariable Long id) {
        BusLine busLine = busLineService.findById(id)
                .orElseThrow(() -> new RuntimeException("BusLine with id " + id + " not found."));
        return busLine;
    }

}
