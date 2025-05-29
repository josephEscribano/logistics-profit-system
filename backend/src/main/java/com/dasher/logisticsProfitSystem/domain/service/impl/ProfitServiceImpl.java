package com.dasher.logisticsProfitSystem.domain.service.impl;

import com.dasher.logisticsProfitSystem.domain.model.Profit;
import com.dasher.logisticsProfitSystem.domain.service.ProfitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProfitServiceImpl implements ProfitService {

    @Override
    public Profit save(Profit profit) {
        return null;
    }

    @Override
    public List<Profit> findAll() {
        return List.of();
    }
}
