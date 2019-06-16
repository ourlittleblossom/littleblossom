import React from 'react';
import Home1 from "./Home1.png";
import Home2 from "./Home2.png";
import request from 'superagent';
import * as Constants from '../Constants';
import "react-responsive-carousel/lib/styles/carousel.min.css";
import { Carousel } from "react-responsive-carousel";
import './Home.scss';
interface IHomeData {
    images: string[];
}
export interface IState {
    data: IHomeData;
}
export class Home extends React.Component<{}, IState> {
    constructor(props: any) {
        super(props);
        this.state = { data: {} as IHomeData };
    }
    private _isMounted: boolean = false;
    public componentDidMount(): void {
        this._isMounted = true;
        request
            .get(Constants.serverConstants.serverIP + '/homeDetails')
            .set('Content-Type', 'application/json')

            .set('Accept', 'application/json')
            .end((err, resp) => {
                if (!err && this._isMounted) {
                    this.setState({ data: resp.body as IHomeData });
                }
            });
    }
    public render() {
        let renderedList: JSX.Element[] = [];
        if (this.state.data.images && this.state.data.images.length > 0) {
            this.state.data.images.forEach((image) => {
                renderedList.push(this._getImages(image));
            })
        }
        return (
            <div className="carousel-container">
                <Carousel
                    autoPlay={true}
                    infiniteLoop={true}>
                   
                {renderedList}

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
    private _getImages(image: string): JSX.Element {
        return (
            <div className="image-container"  key={image}>
                <img className="single-image" src={image} />

            </div>
        );
    }
}
