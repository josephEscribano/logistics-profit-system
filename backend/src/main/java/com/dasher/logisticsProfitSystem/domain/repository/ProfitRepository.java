package com.dasher.logisticsProfitSystem.domain.repository;

import com.dasher.logisticsProfitSystem.domain.model.Profit;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfitRepository extends JpaRepository<Profit, UUID> {}