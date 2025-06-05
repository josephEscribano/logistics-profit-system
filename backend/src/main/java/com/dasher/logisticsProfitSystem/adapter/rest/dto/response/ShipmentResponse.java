package com.dasher.logisticsProfitSystem.adapter.rest.dto.response;

import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentResponse {
  private UUID shipmentId;
  private String trackingNumber;
  private List<ProfitResponse> profits;
}
