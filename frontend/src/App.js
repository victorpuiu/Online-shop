import React from "react";
import {Route, Routes} from "react-router-dom";
import "./App.css";
import {Footer} from "./components/Footer";
import {About} from "./pages/about";
import Home from "./pages/home";
import {Marketplaces} from "./pages/marketplaces";
import {Contact} from "./pages/contact";
import Navbar from "./components/Navbar";
import Categories from "./pages/categories";
import Products from "./pages/products";
import Product from "./pages/product";
import Sell from "./pages/sell";
import Login from "./pages/login";

function App() {

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
        {/*<Route path="/marketplaces/:idMarketplace" element={<Marketplaces />} />*/}

        <Route path="/marketplaces/:idMarketplace/categories" element={<Categories />} />
        {/*<Route path="/marketplaces/:idMarketplace/categories/:idCategory" element={<Categories/>} />*/}

        <Route path="/marketplaces/:idMarketplace/categories/:idCategory/products" element={< Products />} />

        <Route path="/marketplaces/:idMarketplace/categories/:idCategory/products/:idProduct" element={< Product />} />


        <Route path="/sell" element={<Sell />} />
        {/*<Route path="/list-items" element={<Sell />} />*/}


        {/*<Route path="/residential" element={<Residential />}/>*/}
        {/*<Route path="/commercial" element={<Commercial />}/>*/}
        {/*<Route path="/land" element={<Land />} />*/}

          <Route path="/login" element={<Login />} />

      </Routes>
      <Footer />
    </div>
  );
}

export default App;
