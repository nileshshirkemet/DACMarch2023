import React from 'react'
import { Link } from 'react-router-dom'
import { useSelector } from 'react-redux'
export default function Menu() {

    let ansCart = useSelector(state=>state.cart);
    // console.log(ansCart);


  return (
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <Link class="nav-link active" aria-current="page" to="/">Home</Link>
        </li>
        <li class="nav-item">
          <Link class="nav-link" to="/newuser">New User?</Link>
        </li>
        <li class="nav-item">
          <Link class="nav-link" to="/login">Login</Link>
        </li>

        <li class="nav-item">
          <Link class="nav-link" to="/add-category">Add Category</Link>
        </li>

        <li class="nav-item">
          <Link class="nav-link" to="/add-product">Add Product</Link>
        </li>

        <li class="nav-item">
          <Link class="nav-link" to="/cart">Cart ({ansCart.length})</Link>
        </li>
       
      </ul>
    </div>
  </div>
</nav>
  )
}
