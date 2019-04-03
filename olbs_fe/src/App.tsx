import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import { LandingPage } from "./LandingPage";

class App extends React.Component {

  render() {
    return (
      <div className="App">
       <LandingPage />
      </div>
    );
  }
}

export default App;
