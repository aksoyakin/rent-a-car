package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MODELS")
@EqualsAndHashCode(callSuper = true)
public class Model extends BaseEntity<Integer> {

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brandId")
    private Brand brand;

    @OneToMany(mappedBy = "model")
    private List<Car> cars;


}
