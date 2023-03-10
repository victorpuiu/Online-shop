import React from "react";
import {Link} from "react-router-dom";
import logoImage from "../images/logo.png";

const Navbar = () => {
  return (
    <>
      <header
        className="flex text-xl bg-white justify-between items-center h-16 p-6 pr-32 pl-20 sticky top-0 z-10
        backdrop-filter backdrop-blur-lg text-black shadow-sm font-mono z-2"
        role="navigation"
      >
        <span>
          Hi!
          <Link to="/sign-in" className="text-blue-700 font-sans">
            Sign in
          </Link>
          <span className="text-black font-sans">
            {" or "}
            <Link to="/register" className="text-blue-700 font-sans">
              register
            </Link>
          </span>
        </span>

        <ul className="pr-8 text-black font-sans md:block hidden">
          <li>
            <Link className="p-4" to="/">
              Home
            </Link>
            <Link className="p-4" to="/about">
              About
            </Link>
              <Link className="p-4" to="/contact">
                Contact
              </Link>
              <Link className="p-4" to="/marketplace">
                Marketplace
              </Link>
          </li>
        </ul>


        <nav className="pr-8 text-white font-bold md:block hidden">
          {/*<button className="bg-blue-400 hover:bg-yellow-700 py-2 px-4 rounded-lg">*/}
          {/*    Sell*/}
          {/*</button>*/}
          <Link to="/sell" className="p-4 text-blue-700 align-super font-sans ">
            Sell
          </Link>


          <button
                className="py-4 px-1 relative border-2 border-transparent
                text-gray-800 rounded-full hover:text-gray-400 focus:outline-none focus:text-gray-500
                transition duration-150 ease-in-out"
                aria-label="Cart">
              <svg className="h-6 w-6" fill="none" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                   viewBox="0 0 24 24" stroke="currentColor">
                <path
                    d="M3 3h2l.4 2M7 13h10l4-8H5.4M7 13L5.4 5M7 13l-2.293 2.293c-.63.63-.184 1.707.707 1.707H17m0
                    0a2 2 0 100 4 2 2 0 000-4zm-8 2a2 2 0 11-4 0 2 2 0 014 0z"></path>
              </svg>
              <span className="absolute inset-0 object-right-top -mr-6">
                <div
                    className="inline-flex items-center px-1.5 py-0.5 border-2 border-white rounded-full text-xs
                    font-semi-bold leading-4 bg-red-500 text-white">
                  0
                </div>
              </span>
          </button>
        </nav>
      </header>



      <div
          className="flex items-center p-6 pr-32 pl-16 space-x-6 bg-white shadow-lg hover:shadow-xl transform
          transition duration-500">

        {/*hover:scale-105*/}
        {/*<div className="flex-grow"></div>*/}

        <Link to="/" className="pr-32 text-left">
          <img src={logoImage} alt="Logo" className="inline-block align-middle flex-shrink-0"/>
        </Link>

        <div className="flex border-2 border-black rounded-xl shadow-lg hover:shadow-xl transform transition duration-500">

          <div className="flex ml-96 p-4 w-72 space-x-4 rounded-lg">
            <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6 opacity-30" fill="none" viewBox="0 0 24 24"
                 stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2"
                    d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/>
            </svg>
            <input className="bg-gray-100 outline-none " type="text" placeholder="Article name or keyword..."/>
          </div>

          <div className="flex py-3 px-4 rounded-lg text-gray-500 font-semi-bold cursor-pointer">
            <span>All categories</span>

            <svg xmlns="http://www.w3.org/2000/svg" className="h-6 w-6" fill="none" viewBox="0 0 24 24"
                 stroke="currentColor">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M19 9l-7 7-7-7"/>
            </svg>
          </div>
          </div>


        <button
            type="submit"
            className="bg-blue-400 py-3 px-5 text-white font-semi-bold rounded-lg hover:shadow-lg transition duration-3000 cursor-pointer">
          <span className="flex-grow p-6">Search</span>
        </button>
      </div>

    </>
  );
};

export default Navbar;
