package com.example.springproject.wikipedia_cars;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "wikipedia_car")
public class WikiCar {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carId;

    @Column(name = "description")
    private String description;

    @Column(name = "car_img_1")    
    private String carImg1;

    @Column(name = "car_img_2")   
    private String carImg2;

    @Column(name = "car_img_3")    
    private String carImg3;

    @Column(name = "car_img_4")   
    private String carImg4;

    @Column(name = "car_img_5")    
    private String carImg5;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarImg1() {
        return carImg1;
    }

    public String getCarImg2() {
        return carImg2;
    }

    public String getCarImg3() {
        return carImg3;
    }

    public String getCarImg4() {
        return carImg4;
    }

    public String getCarImg5() {
        return carImg5;
    }

    public void setCarImg1(String carImg1) {
        this.carImg1 = carImg1;
    }

    public void setCarImg2(String carImg2) {
        this.carImg2 = carImg2;
    }

    public void setCarImg3(String carImg3) {
        this.carImg3 = carImg3;
    }

    public void setCarImg4(String carImg4) {
        this.carImg4 = carImg4;
    }

    public void setCarImg5(String carImg5) {
        this.carImg5 = carImg5;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
