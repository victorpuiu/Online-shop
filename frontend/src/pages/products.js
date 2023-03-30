import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import axios from "axios";

const Products = () => {

    const [products, setProducts] = useState([]);

    const {idMarketplace} = useParams();
    const {idCategory} = useParams();


    useEffect(() => {

        axios.get(`http://localhost:8080/markets/${idMarketplace}/categories/${idCategory}/products`)
            .then(response => {
                sessionStorage.setItem("products", JSON.stringify(response.data));
                setProducts(response.data);
            })
            .catch(error => {
                console.error(error);
            })

    }, [idMarketplace, idCategory]);


        console.log(products);

    return (

        <>
            <div className="bg-gray-100 py-8">
                <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                    <h2 className="text-2xl font-bold mb-4">Properties</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {products.map(product => (
                            <Link to={`/marketplaces/${idMarketplace}/categories/${idCategory}/products/${product.id}`} key={product.id}>
                                <div
                                    key={product.id}
                                    className="bg-white rounded-lg shadow-md overflow-hidden">
                                    <img
                                        src={product.image}
                                        alt="Product image"
                                        className="w-full h-56 object-cover"
                                    />
                                    <div className="p-4">
                                        <h3 className="text-lg font-bold mb-2">{product.description}</h3>
                                        <p className="text-gray-700">{product.price}</p>

                                    </div>
                                </div>

                            </Link>
                        ))}
                    </div>
                    </div>


            </div>


            </>

    );

}

export default Products;



//Link: https://fancytailwind.com/app/fancy-laboratory/molecules/categoryfilters/categoryFilter4
// import React, { useState } from 'react'
// import { Switch } from '@headlessui/react'
// import { ViewGridIcon, ViewListIcon } from "@heroicons/react/solid"
//
//
// const CategoryFilter4 = () => {
//
//     const filters = [
//         {
//             id: 'brand',
//             name: 'Brand',
//             options: [
//                 { value: 'buliclo', label: 'Buliclo' },
//                 { value: 'carlotin', label: 'Carlotin' },
//                 { value: 'merguinez', label: 'Merguinez' },
//                 { value: 'swifty', label: 'Swifty' },
//                 { value: 'tamtam', label: 'TamTam' },
//                 { value: 'wakaflaca', label: 'WakaFlaca' },
//                 { value: 'zaram', label: 'Zaram' },
//                 { value: 'zebulus', label: 'Zebulus' },
//             ],
//         },
//         {
//             id: 'color',
//             name: 'Color',
//             options: [
//                 { value: 'black', label: 'Black' },
//                 { value: 'white', label: 'Yellow' },
//                 { value: 'blue', label: 'Blue' },
//                 { value: 'brown', label: 'Purple' },
//                 { value: 'green', label: 'Green' },
//                 { value: 'purple', label: 'Red' },
//             ],
//         },
//         {
//             id: 'size',
//             name: 'Size',
//             options: [
//                 { value: 'xs', label: 'XS' },
//                 { value: 'sm', label: 'SM' },
//                 { value: 'm', label: 'M' },
//                 { value: 'l', label: 'L' },
//                 { value: 'xl', label: 'XL' },
//                 { value: 'xxl', label: 'XXL' },
//             ],
//         },
//     ]
//
//     const [gridView, setGridView] = useState(false)
//     const [menCategory, setMenCategory] = useState(false)
//
//
//     return (
//         <div className="mx-auto py-8 px-4 w-full max-w-7xl bg-white">
//             <div className="relative">
//
//                 {/* :HEAD TITLE */}
//                 <div className="pb-10 sm:py-10 flex flex-col items-center border-b-2 border-gray-200 text-center">
//                     {/* ::Title */}
//                     <h1 className="text-3xl sm:text-4xl text-gray-700 font-extrabold">New Arrivals</h1>
//                     {/* ::Text */}
//                     <p className="mt-5 max-w-xl text-base text-gray-500 font-medium">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Inventore illo natus doloremque necessitatibus obcaecati harum dolorem?</p>
//                 </div>
//
//
//                 {/* :FILTERS CONTAINER */}
//                 <div className="py-5 sm:px-4 flex flex-col-reverse md:flex-row items-center justify-between">
//                     {/* ::Filter Select Input */}
//                     <div className="flex-shrink-0 mt-5 md:mt-0 max-w-sm sm:max-w-none w-full md:w-auto grid sm:grid-flow-col grid-cols-1 sm:auto-cols-fr gap-4">
//                         {filters.map(filter => (
//                             <div key={filter.id} className="col-span-1">
//                                 <label htmlFor={filter.id} className="sr-only">{filter.name}</label>
//                                 <select name={filter.id} id={filter.id} defaultValue={filter.name} className="form-select w-full rounded border border-gray-300 bg-gray-100 text-base text-gray-600 focus:border-rose-500 focus:ring-rose-500">
//                                     <option value="" className="font-semibold">{filter.name}</option>
//                                     {filter.options.map(option => (
//                                         <option value={option.value}>{option.label}</option>
//                                     ))
//                                     }
//                                 </select>
//                             </div>
//                         ))
//                         }
//                     </div>
//                     <div className="flex-grow ml-5 w-full flex items-center justify-around md:justify-between space-x-4">
//                         {/* ::View Grid */}
//                         <span className="inline-flex">
//               {/* :::grid view button */}
//                             <button className={`inline-flex justify-center items-center ${gridView ? "text-rose-500" : "text-gray-400 hover:text-gray-600"}`} onClick={() => setGridView(true)}>
//                 <ViewGridIcon className="w-8 h-8" />
//               </button>
//                             {/* ::list view button*/}
//                             <button className={`ml-2 inline-flex justify-center items-center ${!gridView ? "text-rose-500" : "text-gray-400 hover:text-gray-600"}`} onClick={() => setGridView(false)}>
//                 <ViewListIcon className="w-8 h-8" />
//               </button>
//             </span>
//                         {/* ::Switch Women/Men */}
//                         <div className="flex items-center space-x-2">
//                             <span className="text-sm text-gray-500 font-medium">Women</span>
//                             <Switch
//                                 checked={menCategory}
//                                 onChange={setMenCategory}
//                                 className={`${
//                                     menCategory ? 'bg-rose-600' : 'bg-gray-200'
//                                 } relative inline-flex items-center w-14 h-7 rounded-full transition-all duration-200 ease-in-out`}
//                             >
//                                 <span className="sr-only">Switch to men category</span>
//                                 <span
//                                     className={`${
//                                         menCategory ? 'translate-x-8 bg-white' : 'translate-x-1 bg-rose-500'
//                                     } inline-block w-5 h-5 rounded-full transition-all duration-200 ease-in-out transform`}
//                                 />
//                             </Switch>
//                             <span className="text-sm text-gray-500 font-medium">Men</span>
//                         </div>
//                     </div>
//                 </div>
//
//             </div>
//         </div>
//     )
// }
//
// export default CategoryFilter4


