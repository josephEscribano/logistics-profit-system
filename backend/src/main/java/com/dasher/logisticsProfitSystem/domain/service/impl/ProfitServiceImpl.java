package com.dasher.logisticsProfitSystem.domain.service.impl;

import com.dasher.logisticsProfitSystem.domain.model.Profit;
import com.dasher.logisticsProfitSystem.domain.repository.ProfitRepository;
import com.dasher.logisticsProfitSystem.domain.service.ProfitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProfitServiceImpl implements ProfitService {

  private final ProfitRepository profitRepository;

  public ProfitServiceImpl(ProfitRepository profitRepository) {
    this.profitRepository = profitRepository;
  }

  @Override
  public Profit calculateAndSave(Profit profit) {
    Integer calculate = profit.getIncome() - (profit.getCosts() + profit.getAdditionalCosts());

    profit.setProfit(calculate);
    return profitRepository.save(profit);
  }

}
