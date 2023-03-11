import React, {useState} from 'react';
import Navbar from "./Navbar";
import land from "../images/land.jpg";

const Land = () => {
    const [selectedSubcategory, setSelectedSubcategory] = useState('');
    const [selectedState, setSelectedState] = useState('');
    // const [selectedForSaleBy, setSelectedForSaleBy] = useState('');
    const [selectedPriceRange, setSelectedPriceRange] = useState('');


    const subcategories = ['Residential', 'Commercial', 'Farm', 'Ranch']
    const states = ['California', 'New York', 'Florida'];
    // const forSaleByOptions = ['Owner', 'Agent', 'Builder'];

    const priceRanges = [
        'Under $58,000.00',
        '$58,000.00 to $310,000.00',
        'Over $310,000.00',
    ];

    const handleSubcategoryChange = (event) => {
        setSelectedSubcategory(event.target.value);
    };

    const handleStateChange = (event) => {
        setSelectedState(event.target.value);
    };

    // const handleForSaleByChange = (event) => {
    //     setSelectedForSaleBy(event.target.value);
    // };

    const handlePriceFilter = (event) => {
        setSelectedPriceRange(event.target.value);
    };

    return (
        <>
            <Navbar />
            <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">
                <h2 className="text-3xl font-bold text-gray-900 mb-4">
                    Land Real Estate
                    <img src={land} alt="land" className="w-1/2 h-48 rounded-lg object-cover" />

                </h2>
                <div className="flex items-center justify-between mb-4">
                    <div className="relative inline-block w-1/3">
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
                                    clipRule="even-odd"
                                />
                            </svg>
                        </div>
                    </div>
                    {/*<img src={beautifulHouse} alt="Beautiful House" className="w-1/2 h-48 rounded-lg object-cover" />*/}
                    <div className="relative inline-block w-1/3">
                        <select
                            id="state"
                            className="w-full appearance-none bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"
                            value={selectedState}
                            onChange={handleStateChange}
                        >
                            <option value="">Select a state/province</option>
                            {states.map((state) => (
                                <option key={state} value={state}>
                                    {state}
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
                                    clipRule="even-odd"
                                />
                            </svg>
                        </div>
                    </div>
                    <div className="relative inline-block w-1/4">
                        <select
                            id="price-range"
                            className="w-full appearance-none bg-white border border-gray-400 hover:border-gray-500 px-4 py-2
                            pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"
                            value={selectedPriceRange}
                            onChange={handlePriceFilter}
                        >
                            <option value="">Select price range</option>
                            {priceRanges.map((range) => (
                                <option key={range} value={range}>
                                    {range}
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
                                    d="M10 4a1 1 0 011 1v8.586l3.707-3.707a1 1 0 011.414 1.414l-4.707 4.707a.997.997 0 01-1.414
                                    0L5.879 10.293a1 1 0 011.414-1.414L9 12.586V5a1 1 0 011-1z"
                                    clipRule="even-odd"
                                />
                            </svg>
                        </div>
                    </div>


                    {/*<div className="relative inline-block w-1/3">*/}
                    {/*    <select*/}
                    {/*        id="for-sale-by"*/}
                    {/*        className="w-full appearance-none bg-white border border-gray-400 hover:border-gray-500 px-4 py-2 pr-8 rounded shadow leading-tight focus:outline-none focus:shadow-outline"*/}
                    {/*        value={selectedForSaleBy}*/}
                    {/*        onChange={handleForSaleByChange}*/}
                    {/*    >*/}
                    {/*        <option value="">For sale by</option>*/}
                    {/*        {forSaleByOptions.map((option) => (*/}
                    {/*            <option key={option} value={option}>*/}
                    {/*                {option}*/}
                    {/*            </option>*/}
                    {/*        ))}*/}
                    {/*    </select>*/}
                    {/*    <div className="pointer-events-none absolute inset-y-0 right-0 flex items-center px-2 text-gray-700">*/}
                    {/*        <svg*/}
                    {/*            className="fill-current h-4 w-4"*/}
                    {/*            xmlns="http://www.w3.org/2000/svg"*/}
                    {/*            viewBox="0 0 20 20"*/}
                    {/*        >*/}
                    {/*            <path*/}
                    {/*                fillRule="even-odd"*/}
                    {/*                d="M11.293 7.293a1 1 0 011.414 0l4 4a1 1 0 01-1.414 1.414L12 10.414V16a1 1 0 01-2 0v-5.586l-2.293 2.293a1 1 0 01-1 .414-1.414l4-4z"*/}
                    {/*                clipRule="even-odd"*/}
                    {/*            />*/}
                    {/*        </svg>*/}
                    {/*    </div>*/}
                    {/*</div>*/}
                </div>
            </div>
        </>
    );
};

export default Land;
