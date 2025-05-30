package com.dasher.logisticsProfitSystem.adapter.rest.dto.request;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProfitRequest(
    @NotNull UUID shipmentId,
    @NotNull Integer income,
    @NotNull Integer costs,
    @NotNull Integer additionalCosts) {}
