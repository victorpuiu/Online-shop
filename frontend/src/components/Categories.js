import React, {useEffect, useState} from 'react';
import {Link} from 'react-router-dom';
import Navbar from "./Navbar";
import Content from "./Content";
import axios from "axios";


// const categories = [
//     {
//         name: 'Residential',
//         // subcategories: ['House', 'Apartment'],
//         image: 'https://fastly.picsum.photos/id/49/1280/792.jpg?hmac=NnUJy0O9-pXHLmY2loqVs2pJmgw9xzuixgYOk4ALCXU',
//         link: '/residential'
//     },
//     {
//         name: 'Commercial',
//         // subcategories: ['Office Space', 'Retail Space', 'Warehouse', 'Land'],
//         image: 'https://fastly.picsum.photos/id/43/1280/831.jpg?hmac=glK-rQ0ppFClW-lvjk9FqEWKog07XkOxJf6Xg_cU9LI',
//         link: '/commercial'
//     },
//     {
//         name: 'Land',
//         // subcategories: ['Residential', 'Commercial', 'Farm', 'Ranch'],
//         image: 'https://fastly.picsum.photos/id/46/3264/2448.jpg?hmac=ZHE8nk-Q9uRp4MxgKNvN7V7pYFvA-9BCv99ltY3HBv4',
//         link: '/land'
//     }
// ];

export const Categories = () => {

    const [categories, setCategories] = useState([]);

    useEffect(() => {
        loadCategories();
    }, []);

    const loadCategories = async () => {
        const result = await axios.get("http://localhost:8080/markets");
        // console.log(result);

        if (result.data) {
            let mainMarket = null;
            result.data.forEach(market => market.name === "Real Estate" ? mainMarket = market : "");
            axios.get("http://localhost:8080/markets/" + mainMarket.id + "/categories")
                .then(response => {
                    setCategories(response.data)
                });
            // setCategories(categories.data);
        }
    };


    return (
        <>
            <Navbar />
            <div className="bg-gray-100 py-8">
                <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                    <h2 className="text-2xl font-bold text-gray-900 mb-4">Shop by Category</h2>
                    <div className="grid grid-cols-2 lg:grid-cols-3 gap-4">
                        {categories.map((category) => (
                            <div key={category.name} className="bg-white rounded-lg overflow-hidden shadow-md">
                                <Link to={category.redirectLink}>
                                    <div
                                        className="h-40 bg-cover bg-center"
                                        style={{ backgroundImage: `url(${category.imageUrl})` }}
                                    />
                                    <div className="p-4">
                                        <h3 className="text-lg font-medium text-gray-900 mb-2">{category.name}</h3>
                                        {/*<ul className="text-gray-500 space-y-1">*/}
                                        {/*    {category.subcategories.map((subcategory) => (*/}
                                        {/*        <li key={subcategory} className="flex items-center">*/}
                                        {/*            <FiChevronRight className="mr-1" />*/}
                                        {/*            <span>{subcategory}</span>*/}
                                        {/*        </li>*/}
                                        {/*    ))}*/}
                                        {/*</ul>*/}
                                    </div>
                                </Link>
                            </div>
                        ))}
                    </div>
                </div>
            </div>
            <Content />

        </>
    );
};

