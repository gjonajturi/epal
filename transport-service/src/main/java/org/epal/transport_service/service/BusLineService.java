package org.epal.transport_service.service;


import org.epal.commons.tranport.model.BusLine;

import java.util.List;
import java.util.Optional;

public interface BusLineService {
    List<BusLine> findAll();

    Optional<BusLine> findById(Long id);

}
