package com.dasher.logisticsProfitSystem.adapter.rest.mapper;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ShipmentResponse;
import com.dasher.logisticsProfitSystem.domain.model.Shipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
    componentModel = "spring",
    uses = {ProfitMapper.class})
public interface ShipmentMapper {

  @Mapping(target = "shipmentId", source = "id")
  ShipmentResponse shipmentToShipmentResponse(Shipment shipment);
}
