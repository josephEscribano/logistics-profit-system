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

@RestController
@RequestMapping(
    value = "/projects",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ShipmentController {

  private final ProfitService profitService;
  private final ShipmentService shipmentService;
  private final ProfitMapper profitMapper;
  private final ShipmentMapper shipmentMapper;

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

  @PostMapping
  public ResponseEntity<ProfitResponse> calculateProfit(
      @RequestBody @Valid ProfitRequest profitRequest) {

    Profit profit = profitMapper.shipmentToShipmentProfit(profitRequest);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(
            profitMapper.shipmentToShipmentProfitResponse(profitService.calculateAndSave(profit)));
  }

  @GetMapping("{shipmentId}")
  public ResponseEntity<ShipmentResponse> findById(@PathVariable UUID shipmentId) {

    Shipment shipment = shipmentService.findById(shipmentId);

    return ResponseEntity.ok(shipmentMapper.shipmentToShipmentResponse(shipment));
  }
}
