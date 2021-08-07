package org.epal.transport_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import transport.model.BusLine;

public interface BusLineRepository extends MongoRepository<BusLine, Long> {
}
