package com.example.springproject.wikipedia_cars;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WikiCarRepository extends JpaRepository<WikiCar, Long>{
    
}
