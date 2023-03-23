import React, {useState} from "react";
import logoImage from "../images/logo.png";
import antique from "../images/antique.jpg";
import realEstate from "../images/realEstate.jpeg";
import watches from "../images/watche.jpg";
import {Link, useNavigate} from "react-router-dom";


const Suggest = () => {
    const [productType, setProductType] = useState("");
    const navigate = useNavigate();

    const handleSubmit = (e) => {
        e.preventDefault();
        // Handle form submission
        if (productType === "real-estate"){
            navigate("/list-items")
        }
    };

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
                        <option value="real-estate">Real Estate</option>
                        <option value="watches">Watches</option>
                        <option value="antique">Antique</option>
                    </select>
                </div>
                <button
                    className="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded"
                    type="submit"
                >
                    Sell
                </button>
            </form>
            <div className="mt-4 flex justify-between py-12">
                <div className="w-1/3 bg-gray-200 h-48 mr-2">
                    <img src={realEstate} alt="" className="w-full h-full object-cover" />

                </div>
                <div className="w-1/3 bg-gray-200 h-48 mr-2">
                    <img src={watches} alt="" className="w-full h-full object-cover" />

                </div>
                <div className="w-1/3 bg-gray-200 h-48">
                    <img src={antique} alt="" className="w-full h-full object-cover" />

                </div>
            </div>
        </div>
    );
};

export default Suggest;
