import React, {useEffect, useState} from "react";

import {Link} from "react-router-dom";
import logoImage from "../images/logo.png";
import axios from "axios";
import Long from "long";


const Sell = () => {

    // const [marketType, setMarketType] = useState("");
    const [markets, setMarkets] = useState([]);

    const [categories, setCategories] = useState([]);

    const [propertyType, setPropertyType] = useState(0); //house, ap.

    const [marketId, setMarketId] = useState();
    const [categoryId, setCategoryId] = useState();

    const [description, setDescription] = useState("");
    const [price, setPrice] = useState("");
    const [country, setCountry] = useState("");
    const [city, setCity] = useState("");
    const [street, setStreet] = useState("");
    const [zipcode, setZipcode] = useState("");
    const [number, setNumber] = useState("");

    const [advertisementType, setAdvertisementType] = useState("");


    const [images, setImages] = useState([]);
    // const [videos, setVideos] = useState([]);

    const loadMarketsAndMarketId = async () => {
        const response = await axios.get("http://localhost:8080/markets");
        if (response.data) {
            setMarkets(response.data);
            // response.data.forEach(market =>
            //         market.name === ("real-estate") ? setMarketId(marketType) : ""
            //
            // );

        }
    }
    const loadCategoriesAndCategoryId = async () => {
        const response = await axios.get("http://localhost:8080/markets/" + marketId + "/categories");
        // console.log(response.data);
        if (response.data) {
            setCategories(response.data);
            // response.data.forEach(category => category.name === ("Residential" || "Commercial" || "Land")
            //   ? setCategoryId(category.id) : "");
      }
    }

    const handleImageUpload = (e) => {
        setImages([...images, e.target.files[0]]);
    };

    useEffect(() => {
        loadMarketsAndMarketId();
    }, []);

    useEffect(() => {
        loadCategoriesAndCategoryId();
    }, [marketId]);


    const handleSubmit = async (e) => {
        e.preventDefault();
        const productDto = {
            //market
            marketCategoryDto: Long.fromString(categoryId),             // residential, commercial, land
            propertyType, //house, apartment
            description,
            price,
            address: {
                country,
                city,
                street,
                zipcode,
                number
            },
            advertisementType,
            image: images[0], // using the first image for simplicity

        };
        try {
            await axios.post("http://localhost:8080/markets/" + marketId + "/categories/"
                + categoryId + "/products/saveOrEdit", productDto);
            alert("Your listing has been created!");
        } catch (error) {
            console.log(error);
        }
    };

    // console.log(markets);
    // console.log(categories);
    // console.log(propertyType);
    // console.log(categoryId);

    return (
        <div className=" ml-80 mr-80 my-8">
            <div className="flex items-center justify-center py-4">
                <Link to="/">
                    <img
                        src={logoImage}
                        alt="Logo"
                        className="h-8 w-auto mr-2"
                    />
                </Link>
            </div>

            <hr className="border-gray-300 mb-4" />
            <h1 className="text-3xl font-bold mb-2">Complete Your Listing</h1>
            <hr className="border-gray-300 mb-4" />

            <form onSubmit={handleSubmit}>
                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="productType">
                        Select a market type
                    </label>
                    <select
                        className="w-full border border-gray-400 p-2"
                        id="marketId"
                        value={marketId}
                        onChange={(e) => {
                            // setMarketType(e.target.value);
                            setMarketId(e.target.value)
                            // setCategoryId("");

                        }
                    }
                    >
                        <option value="">Select a market type</option>
                        {markets.map(market => (
                            <option value={market.id} key={market.id}>{market.name}</option>

                        ))}
                    </select>
                </div>

                {marketId && <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="propertyType">
                        Market Category
                    </label>
                    <select
                        className="w-full border border-gray-400 bg-gray-100 p-2"
                        // id="categoryType"
                        // value={categoryType}
                        // onChange={(e) => setCategoryType(e.target.value)}

                        id="categoryId"
                        value={categoryId}
                        onChange={(e) => {
                            setCategoryId(e.target.value);

                        }}

                    >
                        <option value="">Select a market category</option>

                        {categories.map(category => (
                            <option value={category.id} key={category.id}>{category.name}</option>

                        ))}

                    </select>
                </div>}

                {categoryId && (
                    <div className="mb-4">
                        <label className="block font-bold mb-2" htmlFor="propertyType">
                            Property type
                        </label>
                        <select
                            className="w-full border border-gray-400 bg-gray-100 p-2"
                            id="propertyType"
                            value={propertyType}
                            onChange={(e) => {
                                setPropertyType(e.target.value);
                            }}
                        >
                            <option value="">Select a property type</option>
                            {categories.map(category => (
                                category.id === parseInt(categoryId) && (
                                    <>
                                        {category.name === 'Residential' && (
                                            <>
                                                <option value={category.id} key={category.id}>House</option>
                                                <option value={category.id} key={category.name}>Apartment</option>
                                            </>
                                        )}
                                        {category.name === 'Commercial' && (
                                            <>
                                                <option value={category.id} key={category.id}>Office Space</option>
                                                <option value={category.id} key={category.name}>Warehouse</option>
                                            </>
                                        )}
                                        {category.name === 'Land' && (
                                            <>
                                                <option value={category.id} key={category.id}>Urban Area</option>
                                                <option value={category.id} key={category.name}>Farm</option>
                                            </>
                                        )}
                                    </>
                                )
                            ))}
                        </select>
                    </div>
                )}




                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="description">
                        Description
                    </label>
                    <textarea
                        className="w-full border border-gray-400 bg-gray-100 p-2"
                        id="description"
                        rows="4"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="price">
                        Price
                    </label>
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2"
                        id="price"
                        type="number"
                        step="0.01"
                        value={price}
                        onChange={(e) => setPrice(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="country">
                        Address
                    </label>
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2 mb-2"
                        id="country"
                        type="text"
                        placeholder="Country"
                        value={country}
                        onChange={(e) => setCountry(e.target.value)}
                    />
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2 mb-2"
                        id="city"
                        type="text"
                        placeholder="City"
                        value={city}
                        onChange={(e) => setCity(e.target.value)}
                    />
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2 mb-2"
                        id="street"
                        type="text"
                        placeholder="Street"
                        value={street}
                        onChange={(e) => setStreet(e.target.value)}
                    />
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2 mb-2"
                        id="zipcode"
                        type="text"
                        placeholder="Zipcode"
                        value={zipcode}
                        onChange={(e) => setZipcode(e.target.value)}
                    />
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2"
                        id="number"
                        type="text"
                        placeholder="Number"
                        value={number}
                        onChange={(e) => setNumber(e.target.value)}
                    />
                </div>
                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="advertisementType">
                        Advertisement Type
                    </label>
                    <select
                        className="w-full border border-gray-400 bg-gray-100 p-2"
                        id="advertisementType"
                        value={advertisementType}
                        onChange={(e) => setAdvertisementType(e.target.value)}
                    >
                        <option value="">Select an advertisement type</option>
                        {/*<option value="Sale">Sale</option>*/}
                        {/*<option value="Rent">Rent</option>*/}
                        <option value={0}>Sale</option>
                        <option value={1}>Rent</option>
                    </select>
                </div>
                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="images">
                        Photos
                    </label>
                    <input
                        className="w-full border border-gray-400 bg-gray-100 p-2 mb-2"
                        id="images"
                        type="file"
                        accept="image/*"
                        onChange={handleImageUpload}
                    />
                    {/*<label className="block font-bold mb-2" htmlFor="videos">*/}
                    {/*    Videos*/}
                    {/*</label>*/}
                    {/*<input*/}
                    {/*    className="w-full border border-gray-400 bg-gray-100 p-2"*/}
                    {/*    id="videos"*/}
                    {/*    type="file"*/}
                    {/*    accept="video/*"*/}
                    {/*    onChange={handleVideoUpload}*/}
                    {/*/>*/}
                </div>
                <button
                    className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
                    type="submit"
                >
                    Submit
                </button>

            </form>
        </div>
    );
};

export default Sell;


















