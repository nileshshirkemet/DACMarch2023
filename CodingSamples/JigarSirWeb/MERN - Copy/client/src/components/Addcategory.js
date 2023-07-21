import React, { useRef } from 'react';

import axios from 'axios';

import { useNavigate } from 'react-router-dom';

export default function Addcategory() {
    let navigate = useNavigate();

    var catRecord = useRef();

    var myfunc = ()=>{
        // alert()
        console.log(catRecord);
        console.log(catRecord.current.value);

        var data = {
            name:catRecord.current.value
        }

        console.log(data);

        //post record
        var ans = axios.post(
            'http://localhost:9000/category-action',
            data
        );
        ans.then(res=>{
            console.log(res);
            navigate("/");
        })
    }
  return (
    <div className='container'>
      <h1> Add Category </h1>

      <input type='text' placeholder='Category Name' className='form-control' ref={catRecord} /> <br />

      <button onClick={myfunc}>Add</button>
    </div>
  )
}
