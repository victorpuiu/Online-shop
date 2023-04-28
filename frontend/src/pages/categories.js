import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link, useParams} from "react-router-dom";
import Category from "../components/Category";

const Categories = () => {


    const [categories, setCategories] = useState([]);
    const {idMarketplace} = useParams();

    // const [imageIndex, setImageIndex] = useState(0);


    useEffect(() => {

        axios.get(`http://localhost:8080/markets/${idMarketplace}/categories`)
            .then(response => {
                setCategories(response.data);
            })
            .catch(error => {
                console.error(error);
            })

    }, [idMarketplace]);




    // const NextArrow = ({onClick}) => {
    //     return <FaArrowRight className="right-arrow" onClick={onClick}/>;
    // };
    // const PrevArrow = ({onClick}) => {
    //     return <FaArrowLeft className="left-arrow" onClick={onClick}/>;
    // };
    // const settings = {
    //     infinite: true,
    //     dots: true,
    //     autoplay: true,
    //     lazyLoad: true,
    //     speed: 500,
    //     slidesToShow: 3,
    //     centerMode: true,
    //     centerPadding: 0,
    //     nextArrow: <NextArrow/>,
    //     prevArrow: <PrevArrow/>,
    //     beforeChange: (current, next) => setImageIndex(next),
    // };
    //

    // console.log(categories);


    return (
        <>
            <div className="flex flex-wrap pl-32 pr-32 mt-1 py-8">

                <div className="flex flex-col space-y-4 w-60">
                    <h3 className="text-lg font-medium text-gray-900 mb-2">Shop by Category</h3>
                    <ul className="text-gray-500 space-y-1">

                        <li className="items-center">

                            {categories.map(category => (
                                <div key={category.name}>
                                    <Link to={`/marketplaces/${idMarketplace}/categories/${category.id}/products`}>
                                        {category.name}
                                    </Link>
                                </div>
                            ))}
                        </li>
                    </ul>
                </div>

                {categories.map(category => < Category key={category.name} category={category}/>)}
            </div>



            {/*<div className="listing-content">*/}
            {/*    <div className="my-4">*/}
            {/*        <h1 className="text-center text-4xl pt-5 ">Latest Listings</h1>*/}
            {/*    </div>*/}
            {/*    <div>*/}
            {/*        <Slider {...settings} className="top-1/4">*/}

            {/*        {categories.map((category, index) => (*/}
            {/*            <div*/}
            {/*                key={index}*/}
            {/*                className={*/}
            {/*                    index === imageIndex ? "slide active-slide" : "slide"*/}
            {/*                }*/}
            {/*            >*/}
            {/*                <img src={category.image} alt={category.title} />*/}
            {/*                <h2 className="font-bold text-l md:text-2xl px-3 py-2 md:py-3">*/}
            {/*                    {category.title}*/}
            {/*                </h2>*/}
            {/*                <p className="listing-description">{category.description}</p>*/}
            {/*                <p className="md:py-3 px-3 text-sm">*/}
            {/*                    <b>Price: </b>*/}
            {/*                    {category.price}*/}
            {/*                </p>*/}
            {/*            </div>*/}

            {/*        ))}*/}
            {/*        </Slider>*/}
            {/*    </div>*/}
            {/*</div>*/}

            {/*<Content />*/}


        </>
    );

}

export default Categories;