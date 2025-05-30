package com.dasher.logisticsProfitSystem.adapter.rest.dto.response;

import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfitResponse {
  private UUID shipmentId;
  private Integer income;
  private Integer costs;
  private Integer profit;
}
