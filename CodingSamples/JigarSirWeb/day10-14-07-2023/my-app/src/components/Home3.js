//Axios It is used to perform ajax operation
import axios from 'axios';
// This is required to access functionality from React.Componet
import React from 'react';


//Extends all functonalities from React.Component
export default class Home3 extends React.Component{

    //Initialization can be done in constructor
    constructor(){
        super()
        //Initialization of ref variable for 3 text boxes
        this.x1 = React.createRef()
        this.x2 = React.createRef()
        this.x3 = React.createRef()
    }

    myfunc(){
        // check all reference variables
        console.log('Func Called');
        console.log(this.x1);
        console.log(this.x1.current.value);
        console.log(this.x2.current.value);
        console.log(this.x3.current.value);

        var recordToSubmit = {
            name: this.x1.current.value,
            age: this.x2.current.value,
            place: this.x3.current.value
        }

        console.log(recordToSubmit);

        //perform post request using axios with apis
        axios.post('http://localhost:8000/users/' , recordToSubmit)
        .then(responseFromApi => {
            console.log(responseFromApi);
            //redirect
        });
    }
    render(){
        return(
            <div className='container'>
                <h1>Add Record To API</h1>
                <input type='text' ref={this.x1} /> <br />
                <input type='text' ref={this.x2} /> <br />
                <input type='text' ref={this.x3} /> <br />
                <button onClick={()=>{ this.myfunc()}}>Add</button>
            </div>
        )
    }
}