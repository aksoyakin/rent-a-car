package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CARS")
@EqualsAndHashCode(callSuper = true)
public class Car extends BaseEntity<Integer> {

    @Column(name = "MODEL_YEAR")
    private int modelYear;

    @Column(name = "PLATE")
    private String plate;

    @Column(name = "STATE")
    private int state;      //1-available 2-rented 3-under maintenance

    @Column(name = "DAILY_PRICE")
    private double dailyPrice;

    @ManyToOne
    @JoinColumn(name = "modelId")
    private Model model;
}
