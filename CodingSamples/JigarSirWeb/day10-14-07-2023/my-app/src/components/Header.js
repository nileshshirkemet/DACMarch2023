import React from 'react'
import { Link } from 'react-router-dom'

export default function Header() {
    return (
        <div>
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container-fluid">
                    <a class="navbar-brand" href="#">Navbar</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNav">
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <Link class="nav-link active" aria-current="page" to='/home'>Home</Link>
                            </li>
                            <li class="nav-item">
                                <Link class="nav-link" to="/home1">Home1</Link>
                            </li>
                            <li class="nav-item">
                            <Link class="nav-link" to="/home2">Home2</Link>
                            </li>
                            <li class="nav-item">
                            <Link class="nav-link" to="/home3">Home3</Link>
                            </li>

                            <li class="nav-item">
                            <Link class="nav-link" to="/home4">Home4</Link>
                            </li>


                            <li class="nav-item">
                            <Link class="nav-link" to="/contact">Contact</Link>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
    )
}
