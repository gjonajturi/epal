package org.epal.transport_service.repository;

import org.epal.transport_service.model.BusLine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusLineRepository extends MongoRepository<BusLine, Long> {
}
