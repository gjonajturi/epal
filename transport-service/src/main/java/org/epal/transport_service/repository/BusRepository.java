package org.epal.transport_service.repository;

import org.epal.transport_service.model.Bus;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusRepository extends MongoRepository<Bus, Long> {
}
