import React from 'react';
import ReactDOM from 'react-dom';
import App from './components/App';
import './css/style.css';

import {
    createBrowserRouter,
    RouterProvider,
} from "react-router-dom";


import Home from './components/Home';
import Home1 from './components/Home1';
import Home2 from './components/Home2';
import Home3 from './components/Home3';
import Pagenotfound from './components/Pagenotfound';
import Home4 from './components/Home4';

// http://localhost:3000/
// http://localhost:3000/home
// http://localhost:3000/home1
// http://localhost:3000/home2
// http://localhost:3000/home3
const approute = createBrowserRouter([
    {
        path:"/" , 
        element:<App /> , 
        children:[
            {path:"home" , element:<Home />},
            {path:"home1" , element:<Home1 />},
            {path:"home2" , element:<Home2 />},
            {path:"home3" , element:<Home3 />},
            {path:"home4" , element:<Home4 />},
            {path:"*" , element:<Pagenotfound />},
        ]
    }
])

ReactDOM.render(
    <RouterProvider router={approute}></RouterProvider>
    , document.getElementById("root"));