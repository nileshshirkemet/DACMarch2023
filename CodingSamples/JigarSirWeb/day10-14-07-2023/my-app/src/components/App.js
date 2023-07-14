import React from 'react'
import Header from './Header'
import Home from './Home'
import Footer from './Footer'
import Home1 from './Home1'
import Home2 from './Home2'
import Home3 from './Home3'

import { Outlet } from "react-router-dom";

export default function App() {
  return (
    <div>
      <Header/>
      {/* <Home /> */}
      {/* <Home1 place="Mumbai"/> */}
      {/* <Home2 /> */}
      {/* <Home3 /> */}

      <Outlet />
      <Footer />
    </div>
  )
}
