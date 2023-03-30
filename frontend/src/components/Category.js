import {Link} from "react-router-dom";
import React from "react";


const Category = (categoryProps) => {

    // console.log(categoryProps);

    return (
        <>

            <div className="flex flex-wrap mt-1 py-8 pl-18 pr-18">
                <Link to={`/marketplaces/${categoryProps.category.marketId}/categories/${categoryProps.category.id}/products`} className="mr-1">
                    <div className="text-center bg-white rounded-lg overflow-hidden shadow-md p-2">
                        <h3 className="text-xl font-bold mb-2 underline px-4"></h3>
                        <div className="relative h-50 w-96 overflow-hidden">
                            <img
                                src={categoryProps.category.imageUrl}
                                alt="MarketCategory"
                                // className="absolute h-full w-full object-cover"
                                className="h-48 w-full bg-cover bg-center"

                            />
                        </div>
                        <div className="p-4">
                            <h3 className="text-lg font-medium text-gray-900 mb-2">{categoryProps.category.name}</h3>

                        </div>

                    </div>
                </Link>

            </div>



        </>
    );


}


export default Category;