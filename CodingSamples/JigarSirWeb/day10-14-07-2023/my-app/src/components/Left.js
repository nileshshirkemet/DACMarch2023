import axios from 'axios';
import React,{useRef} from 'react'

export default function Left() {
  const x1 = useRef();
  const x2 = useRef();
  const x3 = useRef();

  const addRecord = ()=>{
    console.log('Click Working');
    console.log(x1);
    console.log(x1.current.value);
    console.log(x2.current.value);
    console.log(x3.current.value);

    var objectToStore = {
        name: x1.current.value,
        age:x2.current.value,
        place:x3.current.value
    }
    console.log(objectToStore);

    var ans = axios.post("http://localhost:8000/users/" , objectToStore);

    ans
    .then((valueFromNode)=>{
      console.log(valueFromNode);
    })
    .catch((errFromNode)=>{
      console.log(errFromNode);
    });

  }
  return (
    <div>
       <input ref={x1} type="text" />
       <input ref={x2} type="text" />
       <input ref={x3} type="text" />
       <br />
       <button onClick={addRecord}>Add</button>       
    </div>
  )
}
