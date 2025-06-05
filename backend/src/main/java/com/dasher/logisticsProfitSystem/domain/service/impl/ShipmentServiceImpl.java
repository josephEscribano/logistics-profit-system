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

/**
 * Implementation of the service for managing shipments. Provides business operations related to
 * shipments, such as finding by ID. Utilizes {@link ShipmentRepository} for data persistence.
 *
 *
 * @author Joseph Escribano Barid
 */
@Service
@Slf4j
public class ShipmentServiceImpl implements ShipmentService {

  private final ShipmentRepository shipmentRepository;

  /**
   * Constructor for dependency injection of the shipment repository.
   *
   * @param shipmentRepository The shipment repository to be used for database operations.
   */
  public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
    this.shipmentRepository = shipmentRepository;
  }

  /**
   * Finds a shipment by its unique identifier.
   *
   * @param shipmentId The UUID of the shipment to find. Cannot be null or empty.
   * @return The {@link Shipment} object if found.
   * @throws ShipmentIllegalArgumentException if the {@code shipmentId} is null or empty.
   * @throws ShipmentNotFoundException if no shipment is found with the provided {@code shipmentId}.
   */
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
