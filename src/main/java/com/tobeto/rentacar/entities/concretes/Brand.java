package com.tobeto.rentacar.entities.concretes;

import com.tobeto.rentacar.core.entities.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data                               //getter setter
@NoArgsConstructor                  //argümansız constructor
@AllArgsConstructor                 //argümanlı constructor
@Entity                             //entity olduğunu belirttik
@Table(name = "BRANDS")             //tablo adı verdik
@EqualsAndHashCode(callSuper = true)
public class Brand extends BaseEntity<Integer> {

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Model> models;



}
