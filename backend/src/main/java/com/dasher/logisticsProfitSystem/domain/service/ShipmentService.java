package com.dasher.logisticsProfitSystem.domain.service;

import com.dasher.logisticsProfitSystem.domain.model.Shipment;

import java.util.UUID;

public interface ShipmentService {

    Shipment findById(UUID shipmentId);
}
