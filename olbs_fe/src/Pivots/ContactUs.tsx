import React from 'react';
import request from 'superagent';
import * as Constants from '../Constants';
import './ContactUs.scss';

interface IContactUsDetails {
    fbLink: string,
    emailId: string,
    address: string,
    phone: string
}

export interface IState {
    data: IContactUsDetails;
}

export class ContactUs extends React.Component<{}, IState> {

    public componentDidMount() {

        this._isMounted = true;
        request
            .get(Constants.serverConstants.serverIP + '/OLBS/requestConfiguration/contactUs')
            .set('Content-Type', 'application/json')

            .set('Accept', 'application/json')
            .end((err, resp) => {
                if (!err && this._isMounted) {
                    this.setState({ data: resp.body as  IContactUsDetails});
                }
            })
    }

    public componentWillUnmount():void {
        this._isMounted = false;
    }

    public render() {
        if(this.state && this.state.data){
        return (
            <div className="contact-us-container">
            <div className="school-name">
            Our Little Blossom School Aligarh
            </div>
                <div className="single-detail-container">
                    <div className="detail-header">
                        email :
                </div>
                    <div className="detail-value">
                        {this.state.data.emailId}
                </div>
                </div>

                <div className="single-detail-container">
                    <div className="detail-header">
                        Phone :
                </div>
                    <div className="detail-value">
                        {this.state.data.phone}
                </div>
                </div>

                <div className="single-detail-container">
                    <div className="detail-header">
                        Address :
                </div>
                    <div className="detail-value">
                        {this.state.data.address}
                </div>
                </div>

                <div className="single-detail-container">
                    <a className="detail-header" href={this.state.data.fbLink} target="_blank">
                        Facebook page
                </a>
                </div>
            </div>
        )
    }
    return null;
}

private _isMounted: boolean= false;
}