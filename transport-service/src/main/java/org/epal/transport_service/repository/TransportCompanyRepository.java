package org.epal.transport_service.repository;

import org.epal.transport_service.model.TransportCompany;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransportCompanyRepository extends MongoRepository<TransportCompany, Long> {
}
