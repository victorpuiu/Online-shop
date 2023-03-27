import React, {useEffect, useState} from "react";
import {Route, Routes} from "react-router-dom";
import "./App.css";
import {Footer} from "./components/Footer";
import {About} from "./pages/about";
import Home from "./pages/home";
import {Marketplaces} from "./pages/marketplaces";
import {Contact} from "./pages/contact";
import {RealEstateCategories} from "./components/RealEstateCategories";
import Navbar from "./components/Navbar";
import Categories from "./pages/categories";

function App() {

   // The effect for the dropdown menu.

  const [isOpen, setIsOpen] = useState(false);
  const toggle = () => {
    setIsOpen(!isOpen);
  };
  useEffect(() => {
    const hideMenu = () => {
      if (window.innerWidth > 768 && isOpen) {
        setIsOpen(false);
      }
    };

    window.addEventListener("resize", hideMenu);

    return () => {
      window.removeEventListener("resize", hideMenu);
    };
  });

  return (
    <div>
      <Navbar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route
          path="/about"
          element={<About />}
        />
        <Route path="/contact" element={<Contact />} />


        <Route path="/marketplaces" element={<Marketplaces />} />
        <Route path="/marketplaces/:id" element={<Marketplaces />} />

        <Route path="/marketplaces/:idMarketplace/categories" element={<Categories />} />
        <Route path="/marketplaces/:idMarketplace/categories/:idCategory" element={<RealEstateCategories/>} />


        {/*<Route path="/sell" element={<Suggest />} />*/}
        {/*<Route path="/list-items" element={<Sell />} />*/}


        {/*<Route path="/residential" element={<Residential />}/>*/}
        {/*<Route path="/commercial" element={<Commercial />}/>*/}
        {/*<Route path="/land" element={<Land />} />*/}

      </Routes>
      <Footer />
    </div>
  );
}

export default App;
