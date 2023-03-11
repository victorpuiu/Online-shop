import React from 'react';
import {Link} from 'react-router-dom';
import Navbar from "./Navbar";
import Content from "./Content";

const categories = [
    {
        name: 'Residential',
        // subcategories: ['House', 'Apartment'],
        image: 'https://picsum.photos/id/10/300/200',
        link: '/residential'
    },
    {
        name: 'Commercial',
        // subcategories: ['Office Space', 'Retail Space', 'Warehouse', 'Land'],
        image: 'https://picsum.photos/id/20/300/200',
        link: '/commercial'
    },
    {
        name: 'Land',
        // subcategories: ['Residential', 'Commercial', 'Farm', 'Ranch'],
        image: 'https://picsum.photos/id/30/300/200',
        link: '/land'
    }
];

export const Categories = () => {

    return (
        <>
            <Navbar />
            <div className="bg-gray-100 py-8">
                <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                    <h2 className="text-2xl font-bold text-gray-900 mb-4">Shop by Category</h2>
                    <div className="grid grid-cols-2 lg:grid-cols-3 gap-4">
                        {categories.map((category) => (
                            <div key={category.name} className="bg-white rounded-lg overflow-hidden shadow-md">
                                <Link to={category.link}>
                                    <div
                                        className="h-40 bg-cover bg-center"
                                        style={{ backgroundImage: `url(${category.image})` }}
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

