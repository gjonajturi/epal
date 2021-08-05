package org.epal.transport_service.service;

import org.epal.transport_service.model.Bus;

import java.util.List;

public interface BusService {
    List<Bus> findAll();

    void save(Bus newBus);
}
