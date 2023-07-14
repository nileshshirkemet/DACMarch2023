import React from 'react';

export default class Home1 extends React.Component {
    constructor(){
        super();
        this.state = {
            username: 'John',
            userage:20
        }
    }
    myfunc(){
        this.setState({username:'john cena',userage:22});
        // this.props.place = 'Thane';
    }
    render(){
        return(
           <div className='container'>
              <h1>Display State Variable</h1>
              <p>Name: {this.state.username}</p>
              <p>Age: {this.state.userage}</p>
              <button onClick={()=>{ this.myfunc() }}>Change</button>

              <hr />
              <p>{this.props.place}</p>
           </div> 
        )
    }
}