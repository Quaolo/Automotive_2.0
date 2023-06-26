package com.example.springproject.wikipedia_cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WikiCarService {
    
    @Autowired
    private WikiCarRepository wikiCarRepository;

    public Optional<WikiCar> getWikiCar(Long car_id){
        return wikiCarRepository.findById(car_id);
    }

    public List<WikiCar> getAllWikiCars() {
        List<WikiCar> output = new ArrayList<WikiCar>();
        wikiCarRepository.findAll().forEach(output::add);
        return output;
    }
}
