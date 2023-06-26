package com.example.springproject.used_cars;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api")
public class CarController {

    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars(){
        List<Car> entityList = carService.getAllCars();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCar(@PathVariable long id) {
        Optional<Car> entity = carService.getCar(id);
        if(entity.isPresent())
            return ResponseEntity.ok(entity.get());
        else   
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/carName/{name}")
    public ResponseEntity<Car> getCarByName(@PathVariable String name){
        Optional<Car> entity = carService.getByName(name);
        if(entity.isPresent())
            return ResponseEntity.ok(entity.get());
        else   
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/carsByBrand/{brand}")
    public ResponseEntity<List<Car>> getCarByBrand(@PathVariable String brand){
        List<Car> carsList = carService.getByBrand(brand);
        return ResponseEntity.ok(carsList);
    }

    @GetMapping("/carsByModel/{model}")
    public ResponseEntity<List<Car>> getCarByModel(@PathVariable String model){
        List<Car> carsList = carService.getByModel(model);
        return ResponseEntity.ok(carsList);
    }
}