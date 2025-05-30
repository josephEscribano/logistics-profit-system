package com.dasher.logisticsProfitSystem.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "shipment")
@Getter
@Setter
@EqualsAndHashCode
public class Shipment {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", nullable = false)
  private UUID id;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "shipment", cascade = CascadeType.ALL)
  @JsonManagedReference
  private List<Profit> profits;

  @Column(name = "tracking_number")
  private String trackingNumber;
}
