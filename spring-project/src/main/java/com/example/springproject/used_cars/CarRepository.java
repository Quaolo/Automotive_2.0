package com.example.springproject.used_cars;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long>{
    Optional<Car> findByName(String name);
    List<Car> findByBrand(String brand);
    List<Car> findByModel(String model);
}
