package com.example.springproject.wikipedia_cars;

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
@RequestMapping("/wikipediaapi")
public class WikiCarController {
    
    @Autowired
    WikiCarService wikiCarService;

    @GetMapping("/wikiCars")
    public ResponseEntity<List<WikiCar>> getAllCars(){
        List<WikiCar> entityList = wikiCarService.getAllWikiCars();
        return ResponseEntity.ok(entityList);
    }

    @GetMapping("/wikiCars/{car_id}")
    public ResponseEntity<WikiCar> getCar(@PathVariable long car_id) {
        Optional<WikiCar> entity = wikiCarService.getWikiCar(car_id);
        if(entity.isPresent())
            return ResponseEntity.ok(entity.get());
        else   
            return ResponseEntity.notFound().build();
    }
}
