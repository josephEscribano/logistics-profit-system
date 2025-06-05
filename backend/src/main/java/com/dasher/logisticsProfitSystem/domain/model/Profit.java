package com.dasher.logisticsProfitSystem.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
    name = "profit",
    indexes = {
      @Index(name = "index_profit_shipment_id", columnList = "shipment_id"),
      @Index(name = "idx_profit_cost_id", columnList = "cost_id"),
      @Index(name = "idx_profit_income_id", columnList = "income_id")
    })
@Getter
@Setter
@EqualsAndHashCode
public class Profit {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "shipment_id")
  @JsonBackReference
  private Shipment shipment;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "cost_id")
  @JsonManagedReference
  private Cost cost;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "income_id")
  @JsonManagedReference
  private Income income;

  @Column(name = "profit", nullable = false)
  private BigDecimal profit;
}
