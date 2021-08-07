package org.epal.transport_service.service;

import org.epal.commons.tranport.model.BusLine;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusLineServiceImpl implements BusLineService {
    static List<BusLine> list = new ArrayList<>();

    @Override
    public List<BusLine> findAll() {
        list.add(new BusLine(1L, "Tirana-Durres"));
        list.add(new BusLine(2L, "Tirana-Vlore"));
        list.add(new BusLine(3L, "Tirana-Shkoder"));
        return null;
    }

    @Override
    public Optional<BusLine> findById(Long id) {
        return Optional.empty();
    }

}
