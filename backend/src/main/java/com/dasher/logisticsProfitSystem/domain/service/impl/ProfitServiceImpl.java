package com.dasher.logisticsProfitSystem.domain.service.impl;

import com.dasher.logisticsProfitSystem.adapter.rest.exception.ShipmentIllegalArgumentException;
import com.dasher.logisticsProfitSystem.domain.model.Profit;
import com.dasher.logisticsProfitSystem.domain.repository.ProfitRepository;
import com.dasher.logisticsProfitSystem.domain.service.ProfitService;
import jakarta.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Implementation of the service for managing profit calculation and persistence. This service
 * handles the business logic related to calculating and saving profit for shipments.
 *
 * @author Joseph Escribano Barid
 */
@Service
@Slf4j
public class ProfitServiceImpl implements ProfitService {

  private final ProfitRepository profitRepository;

  /**
   * Constructs a new ProfitServiceImpl with the given profit repository. Spring's dependency
   * injection will provide this instance.
   *
   * @param profitRepository The repository responsible for profit data access and persistence.
   */
  public ProfitServiceImpl(ProfitRepository profitRepository) {
    this.profitRepository = profitRepository;
  }

  /**
   * Calculates the profit or loss for a given {@link Profit} entity and saves it. The profit is
   * calculated as Income minus Total Costs (CostAmount + AdditionalCost). This operation is
   * transactional.
   *
   * @param profit The {@link Profit} entity containing income, cost details, and shipment
   *     information. It must not be null.
   * @return The updated {@link Profit} entity with the calculated profit/loss value saved.
   * @throws ShipmentIllegalArgumentException if the provided {@code profit} object is null.
   */
  @Override
  @Transactional
  public Profit calculateAndSave(Profit profit) {
    if (Objects.isNull(profit)) {
      String message = "Profit cannot be null";
      log.error(message);
      throw new ShipmentIllegalArgumentException(message);
    }

    // Calculate total cost by summing the base cost amount and additional cost.
    BigDecimal totalCost =
        profit.getCost().getCostAmount().add(profit.getCost().getAdditionalCost());
    BigDecimal calculate = profit.getIncome().getIncomeAmount().subtract(totalCost);

    // Calculate the profit by subtracting total costs from profits
    profit.setProfit(calculate);

    log.info("Saving profit to shipment with id {}", profit.getShipment().getId());
    return profitRepository.save(profit);
  }
}
