package com.dasher.logisticsProfitSystem.domain.model;

import jakarta.persistence.*;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profit")
@Getter
@Setter
public class Profit {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @Column(name = "income", nullable = false)
  private Integer income;

  @Column(name = "costs", nullable = false)
  private Integer costs;
}
