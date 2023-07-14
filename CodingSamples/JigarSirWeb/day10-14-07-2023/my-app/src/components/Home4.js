import React, { useEffect, useState } from 'react'

export default function Home4() {
    var[api,setApi] = useState([])
    const fetchdata = async ()=>{
        console.log('Call API');
        var ans = await fetch('http://localhost:8000/users');
        // console.log(ans);
        var result = await ans.json();
        console.log(result);
        return result;
    }

    useEffect(()=>{
        // console.log( fetchdata() )
        fetchdata().then(values=>{
            setApi(values)
        });
    } , []);
  return (
    <div className='container'>
        <h1> fetch Data From API </h1>
        <table className='table'>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Age</th>
                    <th>Place</th>
                </tr>
            </thead>
            <tbody>
                {
                    api && api.map(objects =>
                        <tr>
                            <td>{objects.name}</td>
                            <td>{objects.age}</td>
                            <td>{objects.place}</td>
                        </tr>    
                    )
                }
            </tbody>
        </table>
    </div>
  )
}
