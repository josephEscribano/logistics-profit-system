package com.dasher.logisticsProfitSystem.adapter.rest.controller;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.request.ProfitRequest;
import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ProfitResponse;
import com.dasher.logisticsProfitSystem.adapter.rest.mapper.ProfitMapper;
import com.dasher.logisticsProfitSystem.domain.model.Profit;
import com.dasher.logisticsProfitSystem.domain.service.ProfitService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
    value = "/projects",
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class ProfitController {

  private final ProfitService profitService;

  private final ProfitMapper profitMapper;

  public ProfitController(ProfitService profitService, ProfitMapper profitMapper) {
    this.profitService = profitService;
    this.profitMapper = profitMapper;
  }

  @PostMapping
  public ResponseEntity<ProfitResponse> calculateProfit(
      @RequestBody @Valid ProfitRequest profitRequest) {

    Profit profit = profitMapper.shipmentRequestToShipment(profitRequest);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(profitMapper.shipmentToShipmentResponse(profitService.save(profit)));
  }
}
