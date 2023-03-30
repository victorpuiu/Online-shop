import {Link} from "react-router-dom";
import React from "react";

const Marketplace = (marketplaceProps) => {


    // console.log(marketplaceProps);
    return (

        <>
            <div className="text-center">

                <Link to={"/marketplaces/" + marketplaceProps.marketPlace.id + "/categories"} className="mr-1">
                    {marketplaceProps.marketPlace.name}
                    <div className="text-center">
                        <h3 className="text-xl font-bold mb-2 underline px-4"></h3>
                        <div className="relative h-72 w-full overflow-hidden">
                            <img
                                src={marketplaceProps.marketPlace.marketImageUrl}
                                alt="MarketImage"
                                className="absolute h-full w-full object-cover"
                            />
                        </div>
                    </div>
                </Link>

            </div>
        </>
    );

}

export default Marketplace;