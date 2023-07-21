import React from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { removeFromCart } from '../redux/slices/cartSlice';

export default function Cart() {
    let dispatch = useDispatch();
    let ansCart = useSelector(state=>state.cart);
    var removeValue = (obj)=>{
        dispatch(removeFromCart(obj))
    }
  return (
    <div className='container'>
        <h1> Cart Record</h1>
        <div className='row'>
        {
            ansCart && ansCart.map(obj=>
                <div className="col-xl-3 text-center p-5 border">
                    <h2>{obj.price}</h2>
                    <p>{obj.name}</p>
                    <p>
                        <button onClick={()=>{removeValue(obj)}}>Remove</button>
                    </p>
                </div>    
            )
        
        }
        </div>  
    </div>
  )
}
