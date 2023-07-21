import React, { useState } from 'react'
import Showcategory from './Showcategory'
import Showproduct from './Showproduct'

export default function Home() {
    var[categoryid,setCategory] = useState('');

    function dataCollect(catid){
        console.log('In Home Comp',catid);
        setCategory(catid)
    }
  return (
    <div className='container'>
    APP {categoryid}
       <div className="row">
            <div className="col-xl-3">
                <Showcategory x1={dataCollect} x2="100" />
            </div>
            <div className="col-xl-9">
                <Showproduct x3={categoryid}  />
            </div>
       </div>
    </div>
  )
}
