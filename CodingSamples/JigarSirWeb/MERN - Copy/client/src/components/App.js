import React from 'react'
import Menu from './Menu'
import { Outlet } from 'react-router-dom'

import { Provider } from 'react-redux'
import { store1 } from '../redux/store'


export default function App() {
  return (
    <Provider store={store1}>
        <div>
            <Menu />
            <Outlet />
        </div>
    </Provider>
  )
}
