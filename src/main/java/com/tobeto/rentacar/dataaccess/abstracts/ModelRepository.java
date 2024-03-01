package com.tobeto.rentacar.dataaccess.abstracts;

import com.tobeto.rentacar.entities.concretes.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ModelRepository extends JpaRepository<Model,Integer> {
    @Query("Select m from Model m where m.name=:name")
    Model findByName(String name);
}
