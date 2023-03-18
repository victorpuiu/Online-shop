import {useState} from "react";


export const ContentCategories = () => {

    // const [selectedSubcategory, setSelectedSubcategory] = useState('');
    const [selectedState, setSelectedState] = useState('');
    // const [selectedForSaleBy, setSelectedForSaleBy] = useState('');
    const [selectedPriceRange, setSelectedPriceRange] = useState('');

    const states = ['California', 'New York', 'Florida'];
    // const forSaleByOptions = ['Owner', 'Agent', 'Builder'];

    const priceRanges = [
        'Under $58,000.00',
        '$58,000.00 to $310,000.00',
        'Over $310,000.00',
    ];

    // const handleSubcategoryChange = (event) => {
    //     setSelectedSubcategory(event.target.value);
    // };

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

        <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-8">

            <div className="flex items-center mb-4 mr-24">

                <div className="relative inline-block w-1/2">
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
                <div className="relative inline-block w-1/2 ml-4">
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

            </div>

        </div>

    );

}