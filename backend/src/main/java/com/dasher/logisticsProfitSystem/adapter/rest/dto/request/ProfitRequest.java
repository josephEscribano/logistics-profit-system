package com.dasher.logisticsProfitSystem.adapter.rest.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record ProfitRequest(
    @NotNull UUID shipmentId,
    @NotNull BigDecimal income,
    @NotNull BigDecimal costs,
    @NotNull BigDecimal additionalCosts) {}
