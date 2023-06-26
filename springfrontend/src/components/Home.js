import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';

import 'bootstrap/dist/css/bootstrap.min.css';
import { Col, InputGroup, FormControl } from 'react-bootstrap';

export default function Home() {
    const [cars, setCars] = useState([]);

    const [searchInput, setSearchInput] = useState('');

    useEffect(() => {
        loadCars();
    }, []);

    const loadCars = async () => {
        const result = await axios.get("http://localhost:8080/api/cars");
        setCars(result.data);
    };

    return (
        <div className = "py-4">
            <div className = "col-md-12 text-center" style = {{ marginTop: '10px', marginBottom: '30px' }}>
                <Col xs = {10} md = {7} lg = {4} className = "mb-3 mx-auto">
                    <InputGroup className = "mb-3" style = {{display: 'inline-block'}}>
                        <InputGroup.Text>🔍&nbsp;&nbsp;
                            <FormControl
                                placeholder = "Search"
                                value = {searchInput}
                                onChange = {(e) => setSearchInput(e.target.value)}
                            />
                        </InputGroup.Text>
                        
                        <div style = {{marginTop: '20px', marginBottom: '-15px'}}>
                            <Link className = "btn btn-success mx-2" style = {{marginTop: '10px', display: 'inline'}} to = {`/searchByBrand/${searchInput}`}>
                                Brand
                            </Link>
                            <b>or</b>
                            <Link className = "btn btn-danger mx-2" style = {{marginTop: '10px', display: 'inline'}} to = {`/searchByModel/${searchInput}`}>
                                Model
                            </Link>
                        </div>
                        
                    </InputGroup>
                
                    
                </Col>
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
                                <Link
                                    className = "btn btn-info mx-2"
                                    to = {`/viewcar/${car.id}`}
                                >
                                    View
                                </Link>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}