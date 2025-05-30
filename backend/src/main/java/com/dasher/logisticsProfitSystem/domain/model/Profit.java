package com.dasher.logisticsProfitSystem.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "profit")
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

  @Column(name = "income", nullable = false)
  private Integer income;

  //TODO: HACER UNA TABLA CON ESTOS DOS DATOS A PARTE PARA QUE DEVUELVA LA SUMA DE LOS MISMOS
  @Column(name = "costs", nullable = false)
  private Integer costs;

  @Column(name = "additional_costs")
  private Integer additionalCosts;

  @Column(name = "profit", nullable = false)
  private Integer profit;
}
