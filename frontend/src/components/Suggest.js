import React, {useEffect, useState} from "react";
import logoImage from "../images/logo.png";
import {Link, useNavigate} from "react-router-dom";
import axios from "axios";


const Suggest = () => {

    const [markets, setMarkets] = useState([]);


    const [productType, setProductType] = useState("");
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission
        if (productType === "real-estate"){
            navigate("/list-items")
        }
    };


    useEffect(() => {

        axios.get("http://localhost:8080/markets")
            .then(response => {
                setMarkets(response.data);
            })

    }, []);

    console.log(markets);
    console.log(productType);

    return (
        <div className="w-full max-w-4xl mx-auto">
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
            <div>
                <h1 className="text-4xl font-bold py-12" >Start your listing</h1>

            </div>

            <form onSubmit={handleSubmit}>
                <div className="mb-4">
                    <label className="block font-bold mb-2" htmlFor="productType">
                        Select a product type
                    </label>
                    <select
                        className="w-full border border-gray-400 p-2"
                        id="productType"
                        value={productType}
                        onChange={(e) => setProductType(e.target.value)}
                    >
                        <option value="">Select a product type</option>
                        {markets.map(market => (
                            <option value={market.name} key={market.name}>{market.name}</option>

                        ))}
                    </select>
                </div>
                <button
                    className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
                    type="submit"
                >
                    Sell
                </button>
            </form>
            <div className="mt-4 flex py-12 flex-wrap mr-2">
                {markets.map((market) => (
                    <div key={market.name} className="w-full sm:w-1/3 bg-gray-200 h-48 mb-2 sm:mb-0 sm:mr-2">
                        <img src={market.marketImageUrl} alt="" className="w-full h-full object-cover" />
                    </div>
                ))}
            </div>


        </div>
    );
};

export default Suggest;





//Component: https://postsrc.com/components/tailwind-css-filters/tailwind-css-basic-filter
// <div className="w-full md:w-2/3 shadow p-5 rounded-lg bg-white">
//     <div className="relative">
//         <div className="absolute flex items-center ml-2 h-full">
//             <svg className="w-4 h-4 fill-current text-primary-gray-dark" viewBox="0 0 16 16" fill="none"
//                  xmlns="http://www.w3.org/2000/svg">
//                 <path
//                     d="M15.8898 15.0493L11.8588 11.0182C11.7869 10.9463 11.6932 10.9088 11.5932 10.9088H11.2713C12.3431 9.74952 12.9994 8.20272 12.9994 6.49968C12.9994 2.90923 10.0901 0 6.49968 0C2.90923 0 0 2.90923 0 6.49968C0 10.0901 2.90923 12.9994 6.49968 12.9994C8.20272 12.9994 9.74952 12.3431 10.9088 11.2744V11.5932C10.9088 11.6932 10.9495 11.7869 11.0182 11.8588L15.0493 15.8898C15.1961 16.0367 15.4336 16.0367 15.5805 15.8898L15.8898 15.5805C16.0367 15.4336 16.0367 15.1961 15.8898 15.0493ZM6.49968 11.9994C3.45921 11.9994 0.999951 9.54016 0.999951 6.49968C0.999951 3.45921 3.45921 0.999951 6.49968 0.999951C9.54016 0.999951 11.9994 3.45921 11.9994 6.49968C11.9994 9.54016 9.54016 11.9994 6.49968 11.9994Z"></path>
//             </svg>
//         </div>
//
//         <input type="text" placeholder="Search by listing, location, bedroom number..."
//                className="px-8 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//     </div>
//
//     <div className="flex items-center justify-between mt-4">
//         <p className="font-medium">
//             Filters
//         </p>
//
//         <button className="px-4 py-2 bg-gray-100 hover:bg-gray-200 text-gray-800 text-sm font-medium rounded-md">
//             Reset Filter
//         </button>
//     </div>
//
//     <div>
//         <div className="grid grid-cols-2 md:grid-cols-3 xl:grid-cols-4 gap-4 mt-4">
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">All Type</option>
//                 <option value="for-rent">For Rent</option>
//                 <option value="for-sale">For Sale</option>
//             </select>
//
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">Furnish Type</option>
//                 <option value="fully-furnished">Fully Furnished</option>
//                 <option value="partially-furnished">Partially Furnished</option>
//                 <option value="not-furnished">Not Furnished</option>
//             </select>
//
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">Any Price</option>
//                 <option value="1000">RM 1000</option>
//                 <option value="2000">RM 2000</option>
//                 <option value="3000">RM 3000</option>
//                 <option value="4000">RM 4000</option>
//             </select>
//
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">Floor Area</option>
//                 <option value="200">200 sq.ft</option>
//                 <option value="400">400 sq.ft</option>
//                 <option value="600">600 sq.ft</option>
//                 <option value="800 sq.ft">800</option>
//                 <option value="1000 sq.ft">1000</option>
//                 <option value="1200 sq.ft">1200</option>
//             </select>
//
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">Bedrooms</option>
//                 <option value="1">1 bedroom</option>
//                 <option value="2">2 bedrooms</option>
//                 <option value="3">3 bedrooms</option>
//                 <option value="4">4 bedrooms</option>
//                 <option value="5">5 bedrooms</option>
//             </select>
//
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">Bathrooms</option>
//                 <option value="1">1 bathroom</option>
//                 <option value="2">2 bathrooms</option>
//                 <option value="3">3 bathrooms</option>
//                 <option value="4">4 bathrooms</option>
//                 <option value="5">5 bathrooms</option>
//             </select>
//
//             <select
//                 className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
//                 <option value="">Bathrooms</option>
//                 <option value="1">1 space</option>
//                 <option value="2">2 space</option>
//                 <option value="3">3 space</option>
//             </select>
//         </div>
//     </div>
// </div>



//Component: https://postsrc.com/components/tailwind-css-filters/tailwind-css-simple-filter
// <div className="flex flex-col">
//     <h2 className="text-xl font-bold mb-4 text-stone-600">
//         TailwindCSS Simple Filter
//     </h2>
//
//     <div className="bg-white p-6 rounded-xl shadow-lg">
//         <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
//             <div className="flex flex-col">
//                 <label htmlFor="name" className="font-medium text-sm text-stone-600">Name</label>
//                 <input
//                     type="text"
//                     id="name"
//                     placeholder="john doe"
//                     className="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
//                 >
//             </div>
//
//             <div className="flex flex-col">
//                 <label htmlFor="email" className="font-medium text-sm text-stone-600">Email</label>
//                 <input
//                     type="email"
//                     id="email"
//                     placeholder="johndoe@example.com"
//                     className="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
//                 >
//             </div>
//
//             <div className="flex flex-col">
//                 <label htmlFor="date" className="font-medium text-sm text-stone-600">Published Date</label>
//                 <input
//                     type="date"
//                     id="date"
//                     className="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
//                 >
//             </div>
//
//             <div className="flex flex-col">
//                 <label htmlFor="status" className="font-medium text-sm text-stone-600">Status</label>
//
//                 <select
//                     id="status"
//                     className="mt-2 block w-full rounded-md border-gray-300 shadow-sm focus:border-orange-300 focus:ring focus:ring-orange-200 focus:ring-opacity-50"
//                 >
//                     <option>Active</option>
//                     <option>Pending</option>
//                     <option>Deleted</option>
//                 </select>
//             </div>
//         </div>
//
//         <div className="grid md:flex grid-cols-2 justify-end space-x-4 w-full mt-6">
//             <button
//                 className="px-4 py-2 rounded-lg text-stone-50 bg-stone-400 hover:bg-stone-500 font-bold text-white shadow-lg shadow-stone-200 transition ease-in-out duration-200 translate-10">
//                 Reset
//             </button>
//
//             <button
//                 className="px-4 py-2 rounded-lg text-orange-50 bg-orange-400 hover:bg-orange-500 font-bold text-white shadow-lg shadow-orange-200 transition ease-in-out duration-200 translate-10">
//                 Search
//             </button>
//         </div>
//     </div>
// </div>



//https://fancytailwind.com/categories/











