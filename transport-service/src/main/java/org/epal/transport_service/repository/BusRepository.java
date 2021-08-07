package org.epal.transport_service.repository;

import org.epal.commons.tranport.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Long> {
}
