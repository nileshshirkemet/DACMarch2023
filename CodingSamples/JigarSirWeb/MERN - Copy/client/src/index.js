import React from 'react';
import ReactDOM from 'react-dom';

// generate routing

//generate routes
import {createBrowserRouter,RouterProvider} from 'react-router-dom';

import App from './components/App';
import Register from './components/Register';
import Login from './components/Login';
import Cart from './components/Cart';
import Home from './components/Home';
import Addcategory from './components/Addcategory';
import Addproduct from './components/Addproduct';



//http://localhost:3000/ ==> App
//http://localhost:3000/newuser ==> App/Register
//http://localhost:3000/login ==> App/Login
const clientRoutes = createBrowserRouter([
    {
      path:"/",
      element:<App />,
      children:[
        {
          path:"",
          element:<Home />
        },
        {
          path:"newuser",
          element:<Register />
        },
        {
          path:"login",
          element:<Login />
        },
        {
          path:"cart",
          element:<Cart />
        },
        {
          path:"add-category",
          element:<Addcategory />
        },
        {
          path:"add-product",
          element:<Addproduct />
        }
      ]
    }
]);

ReactDOM.render(
  <RouterProvider router={clientRoutes} /> , document.getElementById('root') );