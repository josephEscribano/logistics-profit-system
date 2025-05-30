package com.dasher.logisticsProfitSystem.adapter.rest.mapper;

import com.dasher.logisticsProfitSystem.adapter.rest.dto.response.ShipmentResponse;
import com.dasher.logisticsProfitSystem.domain.model.Shipment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

  ShipmentResponse shipmentToShipmentResponse(Shipment shipment);
}
