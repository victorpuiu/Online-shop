import React from "react";
import {Link} from "react-router-dom";
import antique from "../antique.jpg";
import realEstate from "../realEstate.jpeg";
import watches from "../watche.jpg";
import Navbar from "../../components/Navbar";

const ContentMarketCategories = () => {

    return (
        <>
            <Navbar />
            <div className="flex bg-gray-100 py-8 pr-32 pl-32">

                {/*<h2 className="text-3xl font-bold text-left mb-8">All Categories</h2>*/}

                <div className="grid grid-cols-4 gap-8">
                    <div className="flex flex-col space-y-4 w-80">
                        <h3 className="text-lg font-medium text-gray-900 mb-2">All Categories</h3>
                        <ul className="text-gray-500 space-y-1">
                            <li className="flex items-center">
                                <Link to="/real-estate" className="mr-1">
                                    Real Estate
                                </Link>
                            </li>
                            <li className="flex items-center">
                                <Link to="/commercial" className="mr-1">
                                    Watches
                                </Link>
                            </li>
                            <li className="flex items-center">
                                <Link to="/land" className="mr-1">
                                    Antique
                                </Link>
                            </li>
                        </ul>
                    </div>
                    <div className="text-center">
                        <Link to="/real-estate">
                            <h3 className="text-xl font-bold mb-2 underline px-4">Real Estate</h3>
                            <div className="relative h-72 w-full overflow-hidden">
                                <img
                                    src={realEstate}
                                    alt="Real Estate"
                                    className="absolute h-full w-full object-cover"
                                />
                            </div>
                        </Link>
                        <ul className="text-lg text-gray-600 mt-4">
                            <li>
                                <Link to="/residential">Residential</Link>
                            </li>
                            <li>
                                <Link to="/commercial">Commercial</Link>
                            </li>
                            <li>
                                <Link to="/land">Land</Link>
                            </li>
                        </ul>
                    </div>
                    <div className="text-center">
                        <Link to="/watches">
                            <h3 className="text-xl font-bold mb-2 underline px-4">Watches</h3>
                            <div className="relative h-72 w-full overflow-hidden">
                                <img
                                    src={watches}
                                    alt="Watches"
                                    className="absolute h-full w-full object-cover"
                                />
                            </div>
                        </Link>
                        <ul className="text-lg text-gray-600 mt-4">
                            <li>
                                <Link to="/watches/mens">Men's Watches</Link>
                            </li>
                            <li>
                                <Link to="/watches/womens">Women's Watches</Link>
                            </li>
                        </ul>
                    </div>
                    <div className="text-center">
                        <Link to="/antiques">
                            <h3 className="text-xl font-bold mb-2 underline px-4">Antiques</h3>
                            <div className="relative h-72 w-full overflow-hidden">
                                <img
                                    src={antique}
                                    alt="Antiques"
                                    className="absolute h-full w-full object-cover"
                                />
                            </div>
                        </Link>
                        <ul className="text-lg text-gray-600 mt-4">
                            <li>
                                <Link to="/antiques/furniture">Furniture</Link>
                            </li>
                            <li>
                                <Link to="/antiques/paintings">Paintings</Link>
                            </li>
                            <li>
                                <Link to="/antiques/ceramics">Ceramics</Link>
                            </li>
                        </ul>
                    </div>
                </div>


            </div>
        </>
    );




};

export default ContentMarketCategories;
