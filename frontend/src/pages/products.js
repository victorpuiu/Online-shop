import {useEffect, useState} from "react";
import {Link, useParams} from "react-router-dom";
import axios from "axios";

const Products = () => {

    const [products, setProducts] = useState([]);

    const {idMarketplace} = useParams();
    const {idCategory} = useParams();

    const [province, setProvince] = useState("state");
    const [filteredProducts, setFilteredProducts] = useState([]);

    const [residentialType, setResidentialType] = useState("All Type");

    useEffect(() => {

        axios.get(`http://localhost:8080/markets/${idMarketplace}/categories/${idCategory}/products`)
            .then(response => {
                sessionStorage.setItem("products", JSON.stringify(response.data));
                setProducts(response.data);
                setFilteredProducts(response.data);
            })
            .catch(error => {
                console.error(error);
            })

    }, [idMarketplace, idCategory]);


    // const filteredProducts = province === 1 ? products : products.filter(product => product.address.city === province);

    useEffect(() => {
        let filtered = products;
        if (province !== "state"){
            filtered = filtered.filter(product => product.address.city === province);
            // console.log(filtered);
        }
        if (residentialType !== "All Type"){
            filtered = filtered.filter(product => product.propertyType === residentialType);
            }


        // console.log(residentialType);
        setFilteredProducts(filtered);

    }, [province, residentialType]);

    console.log(products);
    // console.log(province);
    // console.log(filteredProducts);
    // console.log(residentialType);

    return (

        <>
            <div className=" mx-auto w-full md:w-2/3 shadow p-5 rounded-lg bg-white">
                <div className="flex items-center justify-between mt-4">
                    <p className="font-medium">
                        Filters
                    </p>

                    <button
                        className="px-4 py-2 bg-gray-100 hover:bg-gray-200 text-gray-800 text-sm font-medium rounded-md"
                        onClick={(e) => {
                            setProvince("state");
                            setResidentialType("All Type");
                        }

                    }
                    >
                        Reset Filter
                    </button>
                </div>
                <div>
                    <div className="grid grid-cols-2 md:grid-cols-3 xl:grid-cols-4 gap-4 mt-4">
                        <select
                            className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent
                            focus:border-gray-500 focus:bg-white focus:ring-0 text-sm"
                            id="province"
                            key="province"
                            onChange={(e) => {
                                setProvince(e.target.value);
                            }}
                        >
                            <option value="state">State/Province</option>
                            {/*{[...new Set(products.map(product => product.address.city))].map(city => (*/}
                            {/*    <option value={city} key={city}>{city}</option>*/}
                            {/*))*/}
                            {/*}*/}
                            {products.map(product => (
                                <option value={product.address.city} key={product.id}>{product.address.city}</option>
                            ))}
                        </select>
                        <select
                            className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm"
                            onChange={(e) => {
                                setResidentialType(e.target.value);
                            }
                            }
                        >
                            <option value="All type">All Type</option>
                            <option value="HOUSE">House</option>
                            <option value="APARTMENT">Apartment</option>
                        </select>

                        <select
                            className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
                            <option value="">Advertisement Type</option>
                            <option value="for-rent">For Rent</option>
                            <option value="for-sale">For Sale</option>
                        </select>

                        <select
                            className="px-4 py-3 w-full rounded-md bg-gray-100 border-transparent focus:border-gray-500 focus:bg-white focus:ring-0 text-sm">
                            <option value="">Any Price</option>
                            <option value="1000">Under $47,000.00</option>
                            <option value="2000">$47,000.00 to $250,000.00</option>
                            <option value="3000">Over $250,000.00</option>
                        </select>

                    </div>
                </div>

            </div>

            <div className="bg-gray-100 py-8">
                <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                    <h2 className="text-2xl font-bold mb-4">Properties</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {filteredProducts.map(product => (
                            <Link to={`/marketplaces/${idMarketplace}/categories/${idCategory}/products/${product.id}`}
                                  key={product.id}>
                                <div
                                    key={product.id}
                                    className="bg-white rounded-lg shadow-md overflow-hidden">
                                    <img
                                        src={product.image}
                                        alt="Product image"
                                        className="w-full h-56 object-cover"
                                    />
                                    <div className="p-4">
                                        <h3 className="text-lg font-bold mb-2">{product.description}</h3>
                                        <p className="text-gray-700">{product.price}</p>

                                    </div>
                                </div>

                            </Link>
                        ))}
                    </div>
                </div>

            </div>

        </>

    );

}

export default Products;
