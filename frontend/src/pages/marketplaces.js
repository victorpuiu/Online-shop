import React, {useEffect, useState} from "react";
import axios from "axios";
import Marketplace from "../components/Marketplace";
import {Link} from "react-router-dom";

export const Marketplaces = () => {


    const [marketPlaces, setMarketPlaces] = useState([]);

    useEffect(() => {

        axios.get("http://localhost:8080/markets")
            .then(response => {
                setMarketPlaces(response.data);
            });

    }, []);

    // console.log(marketPlaces);

    return (
        <>
            <div className="flex bg-gray-100 py-8 pr-32 pl-32">
                <div className="grid grid-cols-4 gap-8">
                    <div className="flex flex-col space-y-4 w-80">
                        <h3 className="text-lg font-medium text-gray-900 mb-2">All Categories</h3>
                        <ul className="text-gray-500 space-y-1">
                            {marketPlaces.map((marketPlace) => (
                                    <div key={marketPlace.name}>
                                        <Link to={"/marketplaces/" + marketPlace.id + "/categories"}>
                                            {marketPlace.name}
                                        </Link>
                                    </div>
                                )
                            )}
                        </ul>
                    </div>

                    {marketPlaces.map(marketPlace => <Marketplace key={marketPlace.name} marketPlace={marketPlace}/>)}


                </div>


            </div>


        </>

    );
}