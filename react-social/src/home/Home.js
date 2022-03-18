import React, { Component } from 'react';
import './Home.css';
import MainPicture from '../img/main.jpg';


class Home extends Component {
    render() {
        return (
            <div className="home-container">
                <div className="container">
                    <div className="graf-bg-container">
                        <img src={MainPicture}/>
                    </div>
                    <h1 className="home-title">지도/사진 공유 사이트</h1>
                </div>
            </div>
        )
    }
}

export default Home;