package com.dasher.logisticsProfitSystem.adapter.rest.mapper;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.request.ProfitRequest;
import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ProfitResponse;
import com.dasher.logisticsProfitSystem.domain.model.Profit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfitMapper {

  @Mapping(target = "shipment.id", source = "shipmentId")
  Profit shipmentToShipmentProfit(ProfitRequest profitRequest);

  @Mapping(target = "shipmentId", source = "shipment.id")
  ProfitResponse shipmentToShipmentProfitResponse(Profit profit);
}
