package org.epal.client_service.repository;

import client.model.FavBusLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavBusLineRepository extends JpaRepository<FavBusLine,Long> {
}
