package com.dasher.logisticsProfitSystem.adapter.rest.controller;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.request.ProfitRequest;
import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ProfitResponse;
import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ShipmentResponse;
import com.dasher.logisticsProfitSystem.adapter.rest.mapper.ProfitMapper;
import com.dasher.logisticsProfitSystem.adapter.rest.mapper.ShipmentMapper;
import com.dasher.logisticsProfitSystem.domain.model.Profit;
import com.dasher.logisticsProfitSystem.domain.model.Shipment;
import com.dasher.logisticsProfitSystem.domain.service.ProfitService;
import com.dasher.logisticsProfitSystem.domain.service.ShipmentService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * REST controller for managing shipment-related operations,
 * primarily focusing on profit calculation and retrieval.
 * This controller handles incoming HTTP requests and delegates
 * business logic to the respective service layers.
 *
 *
 * @author Joseph Escribano Barid
 */
@RestController
@RequestMapping(
    value = "/shipment",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ShipmentController {

  private final ProfitService profitService;
  private final ShipmentService shipmentService;
  private final ProfitMapper profitMapper;
  private final ShipmentMapper shipmentMapper;

  /**
   * Constructs a new ShipmentController with the necessary services and mappers.
   * Spring's dependency injection will provide these instances.
   *
   * @param profitService The service responsible for profit-related business logic.
   * @param shipmentService The service responsible for shipment-related business logic.
   * @param profitMapper The mapper for converting between Profit DTOs and entities.
   * @param shipmentMapper The mapper for converting between Shipment DTOs and entities.
   */
  public ShipmentController(
      ProfitService profitService,
      ShipmentService shipmentService,
      ProfitMapper profitMapper,
      ShipmentMapper shipmentMapper) {
    this.profitService = profitService;
    this.shipmentService = shipmentService;
    this.profitMapper = profitMapper;
    this.shipmentMapper = shipmentMapper;
  }

  /**
   * Handles POST requests to calculate and save profit for a specific shipment.
   * The request body should contain the necessary profit calculation details.
   *
   * @param profitRequest The {@link ProfitRequest} DTO containing shipment ID, income, and costs.
   * @return A {@link ResponseEntity} containing the created {@link ProfitResponse} DTO
   * and an HTTP status of 201 (Created).
   */
  @PostMapping
  public ResponseEntity<ProfitResponse> calculateProfit(
      @RequestBody @Valid ProfitRequest profitRequest) {

    // Map the incoming ProfitRequest DTO to a Profit entity.
    // Note: Complex entity relationships (like Shipment, Cost, Income objects)
    // are typically handled in the service layer, not directly by the mapper for creation.
    // The mapper here primarily maps scalar fields and prepares the entity for the service.
    Profit profit = profitMapper.profitRequestToProfit(profitRequest);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            profitMapper.profitToProfitResponse(profitService.calculateAndSave(profit)));
  }

  /**
   * Handles GET requests to find a shipment by its unique identifier.
   *
   * @param shipmentId The UUID of the shipment to retrieve, provided as a path variable.
   * @return A {@link ResponseEntity} containing the {@link ShipmentResponse} DTO
   * and an HTTP status of 200 (OK) if the shipment is found.
   * Throws appropriate exceptions (e.g., ShipmentNotFoundException) if not found,
   * which are handled by global exception handlers.
   */
  @GetMapping("{shipmentId}")
  public ResponseEntity<ShipmentResponse> findById(@PathVariable UUID shipmentId) {

    Shipment shipment = shipmentService.findById(shipmentId);

    return ResponseEntity.ok(shipmentMapper.shipmentToShipmentResponse(shipment));
  }
}
