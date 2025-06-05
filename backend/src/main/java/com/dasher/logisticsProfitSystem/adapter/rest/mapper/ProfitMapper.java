package com.dasher.logisticsProfitSystem.adapter.rest.mapper;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.request.ProfitRequest;
import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ProfitResponse;
import com.dasher.logisticsProfitSystem.domain.model.Cost;
import com.dasher.logisticsProfitSystem.domain.model.Income;
import com.dasher.logisticsProfitSystem.domain.model.Profit;
import java.math.BigDecimal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfitMapper {

  @Mapping(target = "shipment.id", source = "shipmentId")
  @Mapping(target = "cost.costAmount", source = "costs")
  @Mapping(target = "cost.additionalCost", source = "additionalCosts")
  @Mapping(target = "income.incomeAmount", source = "income")
  Profit profitRequestToProfit(ProfitRequest profitRequest);

  @Mapping(target = "shipmentId", source = "shipment.id")
  @Mapping(target = "income", source = "income.incomeAmount")
  @Mapping(target = "totalCosts", source = "cost.totalCosts")
  ProfitResponse profitToProfitResponse(Profit profit);
}
