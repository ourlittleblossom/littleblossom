import React from 'react';
import request from 'superagent';
import * as Constants from '../Constants';
import './About.scss';

interface IAboutData {
    society: string;
    principalMessage: string;
    principalName: string;
    principalImage: string;
    moto: string;
    motoDescription: string;
}

export interface IState {
    data: IAboutData;
}
export class About extends React.Component<{}, IState> {

    constructor(props: any) {
        super(props);
        this.state = {data: {} as IAboutData};
    }

    public componentDidMount(): void {
        this._isMounted = true;
        request
        .get(Constants.serverConstants.serverIP + '/requestConfiguration/aboutUs')
        .set('Content-Type','application/json')

        .set('Accept', 'application/json')
        .end((err, resp) => {
          if (!err && this._isMounted) {
           this.setState({data: resp.body as IAboutData});
          }
         });
    }

    public componentWillUnmount(): void {
        this._isMounted = false;
    }

    public render(){
        if(this.state && this.state.data) {
            return (
                <div className="about-container">
                    <div className="society-details-container section-container">
                        <span className="society-header section-header">
                            Society
                        </span>
                        <div className="society-details">
                            {this.state.data.society}
                        </div>
                    </div>
                    <div className="principal-message-container section-container">
                        <span className="message-header section-header">
                            Principal's Message
                        </span>
                        <div className="message-details">
                            {this.state.data.principalMessage}
                        </div>
                    </div>
                    <div className="moto-container section-container">
                        <span className="moto-header section-header">
                            Our Moto
                        </span>
                        <div className="moto-details">
                            {this.state.data.moto}
                        </div>
                        <div>
                            {this.state.data.motoDescription}
                        </div>
                    </div>
                </div>
            )
        }
        return null;
    }

    private _isMounted:boolean= false;
}