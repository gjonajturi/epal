package org.epal.transport_service.repository;

import org.epal.commons.tranport.model.BusLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusLineRepository extends JpaRepository<BusLine, Long> {
}
