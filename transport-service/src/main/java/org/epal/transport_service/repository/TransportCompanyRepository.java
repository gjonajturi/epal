package org.epal.transport_service.repository;

import org.epal.commons.tranport.model.TransportCompany;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportCompanyRepository extends JpaRepository<TransportCompany, Long> {
}
