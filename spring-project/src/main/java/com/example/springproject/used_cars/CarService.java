package com.example.springproject.used_cars;

import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;

    public Optional<Car> getCar(Long id) {
        return carRepository.findById(id);
    }

    public List<Car> getAllCars() {
        List<Car> output = new ArrayList<Car>();
        carRepository.findAll().forEach(output::add);
        return output;
    }

    public Optional<Car> getByName(String name) {
        return carRepository.findByName(name);
    }

    public List<Car> getByBrand(String brand) {
        List<Car> output = new ArrayList<Car>();
        carRepository.findByBrand(brand).forEach(output::add);;
        return output;
    }
    
    public List<Car> getByModel(String model) {
        List<Car> output = new ArrayList<Car>();
        carRepository.findByModel(model).forEach(output::add);;
        return output;
    }
}