package com.dasher.logisticsProfitSystem.domain.service.impl;

import com.dasher.logisticsProfitSystem.adapter.rest.exception.ShipmentIllegalArgumentException;
import com.dasher.logisticsProfitSystem.adapter.rest.exception.ShipmentNotFoundException;
import com.dasher.logisticsProfitSystem.domain.model.Shipment;
import com.dasher.logisticsProfitSystem.domain.repository.ShipmentRepository;
import com.dasher.logisticsProfitSystem.domain.service.ShipmentService;
import java.util.Objects;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {

  private final ShipmentRepository shipmentRepository;

  public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
    this.shipmentRepository = shipmentRepository;
  }

  @Override
  public Shipment findById(UUID shipmentId) {
    if (Objects.isNull(shipmentId) || Strings.isBlank(String.valueOf(shipmentId))) {
      String message = "Shipment id can't be null or empty";
      log.error(message);
      throw new ShipmentIllegalArgumentException(message);
    }

    return shipmentRepository
        .findById(shipmentId)
        .orElseThrow(
            () -> {
              String message = "Shipment with id " + shipmentId + " not found";
              log.error(message);
              return new ShipmentNotFoundException(message);
            });
  }
}
