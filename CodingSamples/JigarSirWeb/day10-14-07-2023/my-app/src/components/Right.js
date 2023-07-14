import axios from 'axios';
// npm i axios
import React,{useEffect,useState } from 'react'
// useEffect() which is allowed only in functional comp
export default function Right(props) {

    //create state variable
    var[counter,setCounter] = useState(0);
    var[api,setapi] = useState([]);


    var myfunc = ()=>{
        // alert()
        // update state variable counter using dispatcher function i.e. setCounter
        setCounter(counter+100);
        // props.apivalue = 9000;  
    }

    /*
         useState() function comp or hook which is pre defined.
         to hold changable data in a funct component we have to use state instead of props 
    */

    useEffect(()=>{
        //fetch data from an API
        // console.log(axios);
        var ans = axios.get("http://localhost:8000/users");
        // console.log(ans);
        
        ans.then((result)=>{
            // console.log(result);
            console.log(result.data);
            // props.apivalue = result.data;
             console.log("useEffectcall");
             setapi(result.data)
        });

    },[]);
    return (
        <div>
            <p>
                Prop Variable : {props.apivalue}
            </p>
            
            <hr />
            <p>
                State Variable : {counter}
                <button onClick={myfunc}>Change</button>
            </p>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">name </th>
                        <th scope="col">Age </th>
                        <th scope="col">Place </th>
                    </tr>
                </thead>
                <tbody>
                    {
                       api.map((values)=>
                        <tr>
                           <td>{values.name}</td>
                           <td>{values.age}</td>
                           <td>{values.place}</td>
                        </tr>
                       )
                    }
                </tbody>
            </table>
        </div>
    )
}
