package org.epal.client_service.repository;

import org.epal.commons.client.model.FavBusLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavBusLineRepository extends JpaRepository<FavBusLine,Long> {
}
