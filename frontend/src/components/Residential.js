import React, {useEffect, useState} from 'react';
import Navbar from "./Navbar";
import beautifulHouse from "../images/beautifulHouse.jpg";
import {SearchCategories} from "./SearchCategories";
import axios from "axios";
import ProductsResidential from "./ProductsResidential";

const Residential = () => {

    const [selectedSubcategory, setSelectedSubcategory] = useState('');

    const subcategories = ['House', 'Apartment'];

    const handleSubcategoryChange = (event) => {
        setSelectedSubcategory(event.target.value);
    };




    const [marketId, setMarketId] = useState();

    const [categoryId, setCategoryId] = useState();

    const [products, setProducts] = useState([]);

    const loadMarketId = async () => {
        const result = await axios.get("http://localhost:8080/markets")
        if (result.data) {
            // let marketId = null;
            result.data.forEach(market => market.name === "Real Estate" ? setMarketId(market.id) : "");
        }
    }
    const loadCategoryId = async () => {
        const result = await axios.get("http://localhost:8080/markets/" + marketId + "/categories");
        if (result.data) {
            result.data.forEach(category => category.name === "Residential" ? setCategoryId(category.id) : "");
        }
    }
    const loadProducts = async () => {
        try{
            const result = await axios.get("http://localhost:8080/markets/"
                + marketId + "/categories/" + categoryId + "/products");
            setProducts(result.data);
        } catch (error) {
            console.error(error)
        }
    }

    useEffect(() => {
        loadMarketId();
    }, []);

    useEffect(() => {
        loadCategoryId();
    }, []);

    useEffect(() => {
        loadProducts();
    }, []);




    return (

        <>
            <Navbar />
            <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
                <h2 className="text-3xl font-bold text-gray-900 mb-4">
                    Residential Real Estate
                    <img src={beautifulHouse} alt="Beautiful House" className="w-1/2 h-48 rounded-lg object-cover" />
                </h2>
                <div className="flex items-center mb-4 pr-96">

                    <div className="relative inline-block w-1/4 mb-4">
                        <select
                            id="subcategory"
                            className="w-full appearance-none bg-white border border-gray-400 hover:border-gray-500 px-4 py-2
                            pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"
                            value={selectedSubcategory}
                            onChange={handleSubcategoryChange}
                        >
                            <option value="">Select property type</option>
                            {subcategories.map((subcategory) => (
                                <option key={subcategory} value={subcategory}>
                                    {subcategory}
                                </option>
                            ))}

                        </select>
                        <div className="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">
                            <svg
                                className="fill-current h-4 w-4"
                                xmlns="http://www.w3.org/2000/svg"
                                viewBox="0 0 20 20"
                            >
                                <path
                                    fillRule="even-odd"
                                    d="M10 4a1 1 0 011 1v8.586l3.707-3.707a1 1 0 011.414 1.414l-4.707 4.707a.997.997 0 01-1.414 0L5.879 10.293a1 1 0 011.414-1.414L9 12.586V5a1 1 0 011-1z"
                                />
                            </svg>
                        </div>
                    </div>
                    <SearchCategories/>
                </div>

            </div>

            <ProductsResidential products={products}/>
        </>
);

};

export default Residential;
