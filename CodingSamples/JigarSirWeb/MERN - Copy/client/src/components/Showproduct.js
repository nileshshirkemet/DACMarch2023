import React,{useEffect, useState} from 'react'
import  {useDispatch } from 'react-redux'
import { addToCart } from '../redux/slices/cartSlice';
import { useNavigate } from 'react-router-dom';
export default function Showproduct(props) {

    const dispatch = useDispatch();
    let navigate = useNavigate();

    var[record,setRecord] = useState([]);

    async function fetchData(){
        var res = await fetch('http://localhost:9000/show-product');
        var value = await res.json();
        console.log(value);
        setRecord(value['msg'])
    }

    useEffect(()=>{
        fetchData()
    } , []);

    var addValue = (obj)=>{
        console.log('Func Called');
        console.log(obj);
        dispatch(addToCart(obj))
        navigate("/cart");
    }

  return (
    <div>
        <h1>All Products : {props.x3}</h1>
        <div className="row">
        {
            record && record.map(obj=>
                <div className="col-xl-3 text-center p-5 border">
                    <h2>{obj.price}</h2>
                    <p>{obj.name}</p>
                    <p>
                        <button onClick={()=>{addValue(obj)}}>Add To Cart</button>
                    </p>
                </div>    
                
            )
        }
        </div>
    </div>
  )
}
