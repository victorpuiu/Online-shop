import React, {useEffect, useState} from "react";
import axios from "axios";
import {useParams} from "react-router-dom";
import {BadgeCheckIcon} from "@heroicons/react/outline";

const Product = () => {

    const [product, setProduct] = useState();

    const {idMarketplace, idCategory, idProduct} = useParams();


    useEffect(() => {
        let products = JSON.parse(sessionStorage.getItem("products"));
        let productInSessionStorage = false;
        products = products ? products : [];
        products.forEach(product => {
            if (product.id.toString() === idProduct){
                setProduct(product);
                productInSessionStorage = true;
            }
        });

        if (!productInSessionStorage){
            axios.get(`http://localhost:8080/markets/${idMarketplace}/categories/${idCategory}/products/${idProduct}`)
                .then(response => {
                    console.log(response.data);
                    setProduct(response.data);

                })
                .catch(error => {
                    console.error(error);
                })
        }
    }, [idProduct, idCategory, idMarketplace]);


    console.log(product);

    if (!product) {
        return <div>Loading...</div>;
    }

    return (

        <div className="flex flex-col md:flex-row bg-white rounded-lg overflow-hidden shadow-md mt-8">
            <div className="relative md:w-1/2">
                <img
                    src={product.image}
                    alt={product.description}
                    className="w-full h-full object-cover"/>

            </div>
            <div className="p-8 md:w-1/2">
                <div className="mb-4">
                    <h1 className="text-2xl font-bold text-gray-800">{product.description}</h1>
                    <p className="text-lg font-semi-bold text-gray-600">${product.price.toFixed(2)}</p>
                </div>
                <div className="mb-4">
                            <h2 className="text-lg font-semi-bold text-gray-700">Property Type</h2>
                            <p className="text-gray-600">{product.propertyType}</p>
                </div>
                <div className="mb-4">
                            <h2 className="text-lg font-semi-bold text-gray-700">Address</h2>
                            <p className="text-gray-600">{product.address.street}, {product.address.city}, {product.address.state} {product.address.zipCode}</p>
                </div>
                <div className="mb-4">
                            <h2 className="text-lg font-semi-bold text-gray-700">Market Category</h2>
                            {/*<p className="text-gray-600">{product.marketCategoryDto.name}</p>*/}
                </div>
                <div className="mb-4">
                            <h2 className="text-lg font-semi-bold text-gray-700">Advertisement Type</h2>
                    <div className="flex items-center">
                                    {product.advertisementType === "SALE" && (
                                        <BadgeCheckIcon className="w-5 h-5 mr-2 text-green-500" />
                                    )}
                                    {product.advertisementType === "RENT" && (
                                        <BadgeCheckIcon className="w-5 h-5 mr-2 text-blue-500" />
                                    )}
                                    <p className="text-gray-600">{product.advertisementType}</p>
                    </div>
                </div>

                <div className="mb-4">
                    <h2 className="text-lg font-semi-bold text-gray-700">Contact</h2>
                    <p className="text-gray-600">
                        {product.user.username}: {product.user.email}
                    </p>
                </div>


            </div>
        </div>
    );

}

export default Product;