import './App.css';
import {Route, Routes} from "react-router-dom";
import Home from "./pages/home";
import About from "./pages/about";
import Footer from "./components/Footer";
import {useEffect, useState} from "react";

function App() {

    // The effect for the dropdown menu.
    const [isOpen, setIsOpen] = useState(false);
    
    const toggle = () => {
      setIsOpen(!isOpen);
    }

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

          <Route
              path="/"
              element={ <Home isOpen={isOpen} toggle={toggle} />}
          />

          <Route
              path="/about"
              element={ <About isOpen={isOpen} toggle={toggle} /> }
          />

      </Routes>
        <Footer/>

    </div>
  );
}

export default App;
