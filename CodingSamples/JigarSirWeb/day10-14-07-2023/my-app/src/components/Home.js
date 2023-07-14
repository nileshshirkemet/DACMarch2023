import React from 'react'
import Left from './Left'
import Right from './Right'

export default function Home() {
  return (
    <div className='container'>
        <div className="row">
            <div className="col-3">
                <Left />
            </div>
            <div className="col-9">
                <Right apivalue="test" />
            </div>
        </div>
    </div>
  )
}
