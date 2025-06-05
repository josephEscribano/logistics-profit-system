package com.dasher.logisticsProfitSystem.adapter.rest.dto.response;

import java.math.BigDecimal;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfitResponse {
  private UUID shipmentId;
  private BigDecimal income;
  private BigDecimal totalCosts;
  private BigDecimal profit;
}
