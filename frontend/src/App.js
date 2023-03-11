import React, {useEffect, useState} from "react";
import {Route, Routes} from "react-router-dom";
import "./App.css";
import {Footer} from "./components/Footer";
import {About} from "./pages/about";
import Home from "./pages/home";
import {Sell} from "./pages/sell";
import {Marketplace} from "./pages/marketplace";
import {Contact} from "./pages/contact";
import Residential from "./components/Residential";
import Commercial from "./components/Commercial";
import Land from "./components/Land";

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
      <Routes>
        <Route path="/" element={<Home isOpen={isOpen} toggle={toggle} />} />
        <Route
          path="/about"
          element={<About isOpen={isOpen} toggle={toggle} />}
        />
        <Route path="/sell" element={<Sell />} />
        <Route path="/marketplace" element={<Marketplace />} />
        <Route path="/residential" element={<Residential />}/>
        <Route path="/commercial" element={<Commercial />}/>
        <Route path="/land" element={<Land />} />

        <Route path="/contact" element={<Contact />} />
      </Routes>
      <Footer />
    </div>
  );
}

export default App;
