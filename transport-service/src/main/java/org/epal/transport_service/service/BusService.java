package org.epal.transport_service.service;


import org.epal.commons.transport.model.Bus;

import java.util.List;
import java.util.Optional;

public interface BusService {
    List<Bus> findAll();

    void save(Bus newBus);

    Optional<Bus> findInDuty(Long id);


}
