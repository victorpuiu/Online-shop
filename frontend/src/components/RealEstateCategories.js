import React, {useEffect, useState} from 'react';
import {Link} from 'react-router-dom';
import Content from "./Content";
import axios from "axios";

export const RealEstateCategories = () => {

    const [categories, setCategories] = useState([]);

    // console.log(categories);

    useEffect(() => {
        loadCategories();
    }, []);

    const loadCategories = async () => {
        const result = await axios.get("http://localhost:8080/markets");
        // console.log(result);

        if (result.data) {
            let mainMarket = null;
            result.data.forEach(market => market.name === "real-estate" ? mainMarket = market : "");
            axios.get("http://localhost:8080/markets/" + mainMarket.id + "/categories")
                .then(response => {
                    setCategories(response.data)
                });
            // setCategories(categories.data);
        }
    };


    return (
        <>
            {/*<Navbar />*/}
            <div className="flex flex-wrap pl-32 pr-32 mt-1 py-8">
                <div className="flex flex-col space-y-4 w-60">

                    <h3 className="text-lg font-medium text-gray-900 mb-2">Shop by Category</h3>
                    <ul className="text-gray-500 space-y-1">
                        <li className="flex items-center">
                            <Link to="/residential" className="mr-1">
                                Residential
                            </Link>
                        </li>
                        <li className="flex items-center">
                            <Link to="/commercial" className="mr-1">
                                Commercial
                            </Link>
                        </li>
                        <li className="flex items-center">
                            <Link to="/land" className="mr-1">
                                Land
                            </Link>
                        </li>
                    </ul>
                </div>

                <div className="flex flex-wrap w-2/3">
                    {categories.map((category) => (
                        <div key={category.name} className="bg-white rounded-lg overflow-hidden shadow-md w-1/3 p-2">
                            <Link to={category.redirectLink}>
                                <div
                                    className="h-40 bg-cover bg-center"
                                    style={{ backgroundImage: `url(${category.imageUrl})` }}
                                />
                                <div className="p-4">
                                    <h3 className="text-lg font-medium text-gray-900 mb-2">{category.name}</h3>
                                    {/*<ul className="text-gray-500 space-y-1">*/}
                                    {/*  {category.subcategories.map((subcategory) => (*/}
                                    {/*    <li key={subcategory} className="flex items-center">*/}
                                    {/*      <FiChevronRight className="mr-1" />*/}
                                    {/*      <span>{subcategory}</span>*/}
                                    {/*    </li>*/}
                                    {/*  ))}*/}
                                    {/*</ul>*/}
                                </div>
                            </Link>
                        </div>
                    ))}
                </div>
            </div>

            <Content />
        </>
    );
};

