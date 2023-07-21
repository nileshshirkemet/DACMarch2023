import React, { useEffect, useState } from 'react'

export default function Showcategory(props) {
    var[record , setRecord] = useState([]);

    async function fetchData(){
        var res = await fetch('http://localhost:9000/show-category');
        var result = await res.json();
        console.log(result);
        
        setRecord(result['valuesFromNode']);

    }

    var myfunc = (catid)=>{
        // alert()
        console.log('in Cate comp' , catid);
        console.log(props);
        props.x1(catid)
    }

    useEffect(()=>{
        fetchData();
    } , [])
  return (
    <div>
      <h1> Categories</h1>
      {
        record && record.map(obj=>
            <li onClick={()=>{ myfunc(obj._id) }}  style={{'list-style':'none'}}>
                {obj.name}
            </li>    
        )
      }
    </div>
  )
}
