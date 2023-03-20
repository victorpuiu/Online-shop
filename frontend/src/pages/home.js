import React from "react";
import Hero from "../components/Hero";

const Home = ({ isOpen, toggle}) => {
  return (
    <>
        <Hero isOpen={isOpen} toggle={toggle} />
        {/*<Content />*/}
    </>
  );
};

export default Home;
