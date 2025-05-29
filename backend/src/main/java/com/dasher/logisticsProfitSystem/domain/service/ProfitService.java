package com.dasher.logisticsProfitSystem.domain.service;

import com.dasher.logisticsProfitSystem.domain.model.Profit;

import java.util.List;

public interface ProfitService {

    Profit save(Profit profit);

    List<Profit> findAll();


}
