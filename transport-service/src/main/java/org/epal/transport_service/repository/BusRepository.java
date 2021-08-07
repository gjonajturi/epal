package org.epal.transport_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import transport.model.Bus;

public interface BusRepository extends MongoRepository<Bus, Long> {
}
