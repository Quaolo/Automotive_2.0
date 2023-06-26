package com.example.springproject.used_cars;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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
@Table(name = "car")
public class Car {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date_crawled")
    @Size(max = 19)
    private String dateCrawled;

    @Size(max = 66) 
    private String name;

    @Size(max = 6)
    private String seller;

    @Column(name = "offer_type")
    @Size(max = 7)
    private String offerType;

    @Size(max = 6)
    private Integer price;

    @Size(max = 7)
    private String abtest;

    @Column(name = "vehicle_type")
    @Size(max = 10)
    private String vehicleType;
    
    @Column(name = "year_of_registration")
    @Size(max = 4)
    private Integer yearOfRegistration;

    @Size(max = 9)
    private String gearbox;

    @Size(max = 3)
    private Integer powerPS;

    @Size(max = 11)
    private String model;

    @Size(max = 6)
    private Integer kilometer;

    @Column(name = "month_of_registration")
    @Size(max = 2)
    private Integer monthOfRegistration;

    @Column(name = "fuel_type")
    @Size(max = 6)
    private String fuelType;

    @Size(max = 14)
    private String brand;

    @Column(name = "not_repaired_damage")
    @Size(max = 4)
    private String notRepairedDamage;

    @Column(name = "date_created")
    @Size(max = 19)
    private String dateCreated;

    @Column(name = "nr_of_pictures")
    @Size(max = 1)
    private Integer nrOfPictures;

    @Column(name = "postal_code")
    @Size(max = 5)
    private Integer postalCode;

    @Column(name = "last_seen")
    @Size(max = 19)
    private String lastSeen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateCrawled() {
        return dateCrawled;
    }

    public void setDateCrawled(String dateCrawled) {
        this.dateCrawled = dateCrawled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getOfferType() {
        return offerType;
    }

    public void setOfferType(String offerType) {
        this.offerType = offerType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getAbtest() {
        return abtest;
    }

    public void setAbtest(String abtest) {
        this.abtest = abtest;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getYearOfRegistration() {
        return yearOfRegistration;
    }

    public void setYearOfRegistration(Integer yearOfRegistration) {
        this.yearOfRegistration = yearOfRegistration;
    }

    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public Integer getPowerPS() {
        return powerPS;
    }

    public void setPowerPS(Integer powerPS) {
        this.powerPS = powerPS;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getKilometer() {
        return kilometer;
    }

    public void setKilometer(Integer kilometer) {
        this.kilometer = kilometer;
    }

    public Integer getMonthOfRegistration() {
        return monthOfRegistration;
    }

    public void setMonthOfRegistration(Integer monthOfRegistration) {
        this.monthOfRegistration = monthOfRegistration;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNotRepairedDamage() {
        return notRepairedDamage;
    }

    public void setNotRepairedDamage(String notRepairedDamage) {
        this.notRepairedDamage = notRepairedDamage;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Integer getNrOfPictures() {
        return nrOfPictures;
    }

    public void setNrOfPictures(Integer nrOfPictures) {
        this.nrOfPictures = nrOfPictures;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getLastSeen() {
        return lastSeen;
    }

    public void setLastSeen(String lastSeen) {
        this.lastSeen = lastSeen;
    }

    @Override
    public String toString() {
        return "Car [id=" + id + ", dateCrawled=" + dateCrawled + ", name=" + name + ", seller=" + seller
                + ", offerType=" + offerType + ", price=" + price + ", abtest=" + abtest + ", vehicleType="
                + vehicleType + ", yearOfRegistration=" + yearOfRegistration + ", gearbox=" + gearbox + ", powerPS="
                + powerPS + ", model=" + model + ", kilometer=" + kilometer + ", monthOfRegistration="
                + monthOfRegistration + ", fuelType=" + fuelType + ", brand=" + brand + ", notRepairedDamage="
                + notRepairedDamage + ", dateCreated=" + dateCreated + ", nrOfPictures=" + nrOfPictures
                + ", postalCode=" + postalCode + ", lastSeen=" + lastSeen + "]";
    }  
}
