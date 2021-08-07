package org.epal.transport_service.service;


import org.springframework.stereotype.Service;
import transport.model.Bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements BusService {
    static List<Bus> list = new ArrayList<>();

    @Override
    public List<Bus> findAll() {
        list.add(new Bus(1L, "ALB122", "MERCEDS-BENZ"));
        list.add(new Bus(2L, "ALB2322", "MERCEDS-BENZ"));
        list.add(new Bus(3L, "ALB132", "MERCEDS-BENZ"));
        list.add(new Bus(4L, "ALB122", "MERCEDS-BENZ"));
        return list;
    }

    @Override
    public void save(Bus newBus) {
        list.add(newBus);
    }

    @Override
    public Optional<Bus> findInDuty(Long id) {
        return Optional.empty();
    }
}
