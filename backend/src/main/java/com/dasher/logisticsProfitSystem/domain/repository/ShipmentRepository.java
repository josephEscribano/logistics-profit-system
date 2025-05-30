package com.dasher.logisticsProfitSystem.domain.repository;

import com.dasher.logisticsProfitSystem.domain.model.Shipment;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, UUID> {}
