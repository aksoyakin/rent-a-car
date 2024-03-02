package com.tobeto.rentacar.dataaccess.abstracts;

import com.tobeto.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {


    Brand getById(int id);
}
