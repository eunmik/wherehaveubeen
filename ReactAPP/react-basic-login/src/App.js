import React from 'react';
import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Signin from './Signin.js';
import Profile from './Profile.js';

function App() {
  const token = localStorage.getItem('accessToken');

  if(!token) {
    return <Signin />
  }

  return (
    <div className="wrapper">
      <BrowserRouter>
        <Routes>
          <Route path="/profile">
            <Profile />
          </Route>
          <Route path="/">
            <Profile />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;