import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useParams } from "react-router-dom";

export default function ViewCar() {
    const [car, setCar] = useState({
        name: "",
        brand: "",
        model: "",
        vehicleType: "",
        gearbox: "",
        yearOfRegistration: "",
        kilometer: "",
        fuelType: "",
        abtest: "",
        powerPS: "",
        price: "",
        notRepairedDamage: "",
        dateCreated: "",
        postalCode: "",
        lastSeen: "",
        seller: "",
        offerType: "",
    });

    const [wikiCar, setWikiCar] = useState([]);

    const { id } = useParams();

    useEffect(() => {
        loadCar();
        loadWikiCar();
    }, );

    const loadCar = async () => {
        const result = await axios.get(`http://localhost:8080/api/cars/${id}`);
        setCar(result.data);
    };

    const loadWikiCar = async () => {
        const result = await axios.get(`http://localhost:8080/wikipediaapi/wikiCars/${id}`);
        setWikiCar(result.data);
    };

    return (
        <div className = "container">
            <div className = "row">
                <div className = "col-md-12 border rounded p-4 mt-2 shadow">
                    <h2 className = "text-center m-4"><b>Car Details</b></h2>
                    <div className = "card">
                        <div className = "card-header">
                            <div style = {{textAlign: 'center'}}>
                                <b> 
                                    {car.name} 
                                </b>
                            </div>                            
                            <div className = "row content">
                                <div className = "col-sm-4 sidenav">
                                    <div className = "text-center">
                                        <div style = {{marginTop: '20px'}}>
                                            <img
                                                style = {{width:320, height:180}} 
                                                src = {wikiCar.carImg1} 
                                                alt = "not found"
                                                resizeMode = 'stretch' />
                                        </div>
                                        <div style = {{marginTop: '20px'}}>
                                            <img
                                                style = {{width:320, height:180}} 
                                                src = {wikiCar.carImg2} 
                                                alt = "not found"
                                                resizeMode = 'stretch' />
                                        </div>
                                        <div style = {{marginTop: '20px'}}>
                                            <img
                                                style = {{width:320, height:180}} 
                                                src = {wikiCar.carImg3} 
                                                alt = "not found"
                                                resizeMode = 'stretch' />
                                        </div>
                                        <div style = {{marginTop: '20px'}}>
                                            <img
                                                style = {{width:320, height:180}} 
                                                src = {wikiCar.carImg4} 
                                                alt = "not found"
                                                resizeMode = 'stretch' />
                                        </div>
                                        <div style = {{marginTop: '20px', marginBottom: '20px'}}>
                                            <img
                                                style = {{width:320, height:180}} 
                                                src = {wikiCar.carImg5} 
                                                alt = "not found"
                                                resizeMode = 'stretch' />
                                        </div>
                                    </div>
                                </div>
                                <div className = "col-sm-8 text-left">
                                    <div style = {{marginTop: '25px', marginBottom: '40px'}}>
                                        {wikiCar.description}
                                    </div>
                                    <ul className = "list-group list-group-flush">                                
                                        <li className = "list-group-item">
                                        <b>Brand: </b>
                                        {car.brand}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Model: </b>
                                        {car.model}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Vehicle type: </b>
                                        {car.vehicleType}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Fuel type: </b>
                                        {car.fuelType}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Gearbox: </b>
                                        {car.gearbox}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Year of registration: </b>
                                        {car.yearOfRegistration}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Kilometer: </b>
                                        {car.kilometer}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Abtest: </b>
                                        {car.abtest}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Powerps: </b>
                                        {car.powerPS}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Price: </b>
                                        {car.price}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Not repaired damage: </b>
                                        {car.notRepairedDamage}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Date created: </b>
                                        {car.dateCreated}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Postal code: </b>
                                        {car.postalCode}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Last seen: </b>
                                        {car.lastSeen}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Seller: </b>
                                        {car.seller}
                                        </li>
                                        <li className = "list-group-item">
                                        <b>Offer type: </b>
                                        {car.offerType}
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <Link className = "btn btn-success my-2" to = {"/"}>
                        Home
                    </Link>
                </div>
            </div>
        </div>
    );
}