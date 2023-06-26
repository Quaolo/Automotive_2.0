import * as React from 'react';

import { request, setAuthHeader } from '../helpers/axios_helper';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Home from './Home';
import ViewCar from './ViewCar';
import SearchBrands from './SearchBrands';
import SearchModels from './SearchModels';

export default class AuthContent extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            data: []
        }
    };

    componentDidMount() {
        request(
            "GET",
            "/messages",
            {}).then(
            (response) => {
                this.setState({data: response.data})
            }).catch(
            (error) => {
                if (error.response.status === 401) {
                    setAuthHeader(null);
                } else {
                    this.setState({data: error.response.code})
                }
            }
        );
    };

    render() {
        return (
            <div className = "row justify-content-md-center">                               
                <div style = {{ padding: "0 24px 24px" }}>
                    <Router>
                        <Routes>
                            <Route exact path = "/" element = {<Home />} />
                            <Route exact path = "/searchByBrand/:brand" element = {<SearchBrands />} />
                            <Route exact path = "/searchByModel/:model" element = {<SearchModels />} />
                            <Route exact path = "/viewcar/:id" element = {<ViewCar />} />
                        </Routes>
                    </Router>
                </div>
            </div>
        );
    };
}