package com.dasher.logisticsProfitSystem.adapter.rest.dto.response;

import com.dasher.logisticsProfitSystem.domain.model.Profit;
import java.util.List;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShipmentResponse {
    private UUID shipmentId;
    private String trackingNumber;
    private List<Profit> profits;
}
