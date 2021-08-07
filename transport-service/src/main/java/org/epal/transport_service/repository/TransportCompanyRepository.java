package org.epal.transport_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import transport.model.TransportCompany;

public interface TransportCompanyRepository extends MongoRepository<TransportCompany, Long> {
}
