import React from 'react';
import Home1 from "./Home1.png";
import Home2 from "./Home2.png";
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import './Home.scss';

export class Home extends React.Component<{}, {}> {
    public render(){
        return (
            <div className="carousel-container">
                <Carousel 
                autoPlay={true} 
                infiniteLoop={true}>
                <div>
                    <img src={Home1} />
                   
                </div>
                <div>
                <img src={Home2} />
                    
                </div>
               
            </Carousel>
              
                </div>
        )
    }
}