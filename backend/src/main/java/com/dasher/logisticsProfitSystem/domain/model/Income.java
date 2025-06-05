package com.dasher.logisticsProfitSystem.domain.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "income")
@Getter
@Setter
@EqualsAndHashCode
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "income", nullable = false)
    private BigDecimal incomeAmount;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "income")
    @JsonBackReference
    private Profit profit;
}
