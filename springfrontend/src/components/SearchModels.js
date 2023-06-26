import React, { useEffect, useState } from 'react';
import axios from 'axios'
import { Link, useParams } from "react-router-dom";

const SearchModels = () => {
    const [cars, setCars] = useState([]);

    const { model } = useParams();

    useEffect(() => {
        loadCarsByModel();
    }, );

    const loadCarsByModel = async () => {
        const result = await axios.get(`http://localhost:8080/api/carsByModel/${model}`);
        setCars(result.data);
    };

    return (        
        <div className = "py-4">
            <div className = "col-md-12 text-center" style={{marginBottom: '20px'}}>
                <Link className = "btn btn-success my-2" to = {"/"}>
                    Home
                </Link>
            </div>
            <table className = "table border shadow">
                <thead>
                    <tr>
                    <th scope = "col"> </th>
                    <th scope = "col">#</th>
                    <th scope = "col">Name</th>
                    <th scope = "col">Brand</th>
                    <th scope = "col">Model</th>
                    <th scope = "col"> </th>
                    </tr>
                </thead>
                <tbody>
                    {cars.map((car, index) => (
                        <tr>
                            <td></td>
                            <th scope = "row" key = {index}>
                                {index + 1}
                            </th>
                            <td>{car.name}</td>
                            <td>{car.brand}</td>
                            <td>{car.model}</td>
                            <td>
                                <Link className = "btn btn-info mx-2" to = {`/viewcar/${car.id}`}>
                                    View
                                </Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );

};

export default SearchModels;