import React, {useEffect, useState} from "react";
import {FaArrowLeft, FaArrowRight} from "react-icons/fa";
import Slider from "react-slick";
// import axios from "axios";
// import listings from "../data/latest-listings-data";
import axios from "axios";

const Content = () => {


  const [imageIndex, setImageIndex] = useState(0);


  const [marketId, setMarketId] = useState();

  const [categoryId, setCategoryId] = useState();

  const [products, setProducts] = useState([]);

  const loadMarketId = async () => {
    const result = await axios.get("http://localhost:8080/markets")
    if (result.data) {
      // let marketId = null;
      result.data.forEach(market => market.name === "Real Estate" ? setMarketId(market.id) : "");
    }
  }
  const loadCategoryId = async () => {
    const result = await axios.get("http://localhost:8080/markets/" + marketId + "/categories");
    if (result.data) {
      result.data.forEach(category => category.name === "Residential" ? setCategoryId(category.id) : "");
    }
  }
  const loadProducts = async () => {
    try{
      const result = await axios.get("http://localhost:8080/markets/"
          + marketId + "/categories/" + categoryId + "/products");
      setProducts(result.data);
    } catch (error) {
      console.error(error)
    }
  }

  useEffect(() => {
    loadMarketId();
  }, []);

  useEffect(() => {
    loadCategoryId();
  }, []);

  useEffect(() => {
    loadProducts();
  }, []);






  const NextArrow = ({ onClick }) => {
    return <FaArrowRight className="right-arrow" onClick={onClick} />;
  };

  const PrevArrow = ({ onClick }) => {
    return <FaArrowLeft className="left-arrow" onClick={onClick} />;
  };

  const settings = {
    infinite: true,
    dots: true,
    autoplay: true,
    lazyLoad: true,
    speed: 500,
    slidesToShow: 3,
    centerMode: true,
    centerPadding: 0,
    nextArrow: <NextArrow />,
    prevArrow: <PrevArrow />,
    beforeChange: (current, next) => setImageIndex(next),
  };

  return (
      <>
        <div className="listing-content">
          <div className="my-4">
            <h1 className="text-center text-4xl pt-5 ">Latest Listings</h1>
          </div>
          <div>
            {products && products.length > 0 ? (
                <Slider {...settings} className="top-1/4">
                  {products.map((listing, index) => (
                      <div
                          key={index}
                          className={
                          index === imageIndex ? "slide active-slide" : "slide"
                          }
                      >
                        <img src={listing.image} alt={listing.title} />
                        <h2 className="font-bold text-l md:text-2xl px-3 py-2 md:py-3">
                          {listing.title}
                        </h2>
                        <p className="listing-description">{listing.description}</p>
                        <p className="md:py-3 px-3 text-sm">
                          <b>Price: </b>
                          {listing.price}
                        </p>
                      </div>
                  ))}
                </Slider>
            ) : (
                <p>No products available</p>
            )}
          </div>

        </div>

      </>
  );
};

export default Content;