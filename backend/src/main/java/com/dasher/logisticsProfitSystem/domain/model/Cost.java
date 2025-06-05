package com.dasher.logisticsProfitSystem.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cost")
@Getter
@Setter
@EqualsAndHashCode
public class Cost {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "costs", nullable = false)
  private BigDecimal costAmount;

  @Column(name = "additional_costs")
  private BigDecimal additionalCost;

  @Column(name = "total_cost")
  private BigDecimal totalCosts;

  @OneToOne(cascade = CascadeType.ALL, mappedBy = "cost")
  @JsonBackReference
  private Profit profit;

  @PrePersist
  protected void prePersist() {

    this.totalCosts = this.costAmount.add(this.additionalCost);
  }
}
