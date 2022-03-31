//cafe
import React, { Component } from "react";
import './style.css';


class Cafe extends React.Component{
    constructor(props) {
      super();
  
      this.state = {
        menu: 0,
      };
    }

    render(){
        return(
            <div>Cafe Page</div>
        )
    }
  }
  
  export default Cafe;