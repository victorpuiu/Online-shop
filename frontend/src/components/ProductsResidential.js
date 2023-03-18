
const ProductsResidential = (props) => {
    const products = props.products;
    // console.log(products);

    return (
        <>
            <div className="bg-gray-100 py-8">
                <div className="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
                    <h2 className="text-2xl font-bold mb-4">Properties</h2>
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                        {products.map((product) => (
                            <a href={`product/${product.id}`} key={product.id}>

                                <div
                                    key={product.id}
                                    className="bg-white rounded-lg shadow-md overflow-hidden"
                                >
                                    <img
                                        src={product.image}
                                        alt={product.description}
                                        className="w-full h-56 object-cover"
                                    />
                                    <div className="p-4">
                                        <h3 className="text-lg font-bold mb-2">{product.description}</h3>
                                        <p className="text-gray-700">${product.price}</p>
                                    </div>
                                </div>
                            </a>
                        ))}
                    </div>
                </div>
            </div>
        </>


    );

}

export default ProductsResidential;