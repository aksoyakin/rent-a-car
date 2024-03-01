package com.tobeto.rentacar.dataaccess.abstracts;

import com.tobeto.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
