package com.dasher.logisticsProfitSystem.adapter.rest.mapper;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.request.ProfitRequest;
import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ProfitResponse;
import com.dasher.logisticsProfitSystem.domain.model.Profit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfitMapper {

  Profit shipmentRequestToShipment(ProfitRequest profitRequest);

  ProfitResponse shipmentToShipmentResponse(Profit profit);
}
