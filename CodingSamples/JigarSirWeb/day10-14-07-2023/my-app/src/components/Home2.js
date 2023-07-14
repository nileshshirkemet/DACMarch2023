import axios from 'axios';
import React, { Component } from 'react'

export default class Home2 extends Component {
    constructor(){
        super()
        this.state = {
            apidata: []
        }
        console.log('Const 1');
    }
    
    //componentDidMount cycle will be called only once after 1st render
    componentDidMount(){
        console.log('DID Mount 3');
        var ans = axios.get("http://localhost:8000/users");
        console.log(ans);

        ans.then((dataFromApi) =>{
            console.log(dataFromApi);
            console.log(dataFromApi.data);
            //update state variable
            this.setState({
                apidata: dataFromApi.data
            })
        })
    }
  render() {
    console.log('Render 2');
    const RECORD = this.state.apidata;
    console.log(RECORD);
    return (
      <div className='container'>
        <h1> fetch Data From Api and Show</h1>
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
                    RECORD && RECORD.map(objects =>
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
}
