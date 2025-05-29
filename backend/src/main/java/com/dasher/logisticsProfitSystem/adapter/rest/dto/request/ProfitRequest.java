package com.dasher.logisticsProfitSystem.adapter.rest.dto.request;

import jakarta.validation.constraints.NotNull;

public record ProfitRequest(
    @NotNull Integer income, @NotNull Integer costs, @NotNull Integer additionalCosts) {}
