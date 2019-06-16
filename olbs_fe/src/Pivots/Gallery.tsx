import React from 'react';

import { render } from 'react-dom';
import Lightbox from 'react-image-lightbox';
import 'react-image-lightbox/style.css';
import request from 'superagent';
import './Gallery.scss';
import {IEvents} from './GalleryDetails/IEvents';
import * as Constants from '../Constants';
import { IEventDetails } from './GalleryDetails/IEventDetails';




interface IState {
        eventData: IEvents;
    }
export class Gallery2 extends React.Component<{}, IState> {

        constructor(props: any) {
                super(props);
                this.state = {eventData: {} as IEvents};
                
        }
        public componentDidMount() {
                this._isMounted = true;
                request
                .get(Constants.serverConstants.serverIP + '/galleryDetails')
                .set('Content-Type','application/json')
        
                .set('Accept', 'application/json')
                .end((err, resp) => {
                  if (!err && this._isMounted) {
                   this.setState({eventData: resp.body as IEvents});
                  }
                });
          }
        
          public componentWillUnmount(): void {
              this._isMounted= false;
          }
        public render(){
                let renderedList: JSX.Element[] = [];
                let i =0;
                if(this.state && this.state.eventData && this.state.eventData.eventDetails) {
                        this.state.eventData.eventDetails.forEach((eventDetail) => {
                                renderedList.push(this._getImageRow(eventDetail,i++));
                            })
                }
                return (
                        <div style={{display:"flex"}}>{renderedList}</div>
                );
                
                return null;
        }


private _getImageRow(eventDetail: IEventDetails,i:number): JSX.Element {
        
        return (
                <div id="container" key={eventDetail.eventName}>
                        <img id="image" src={eventDetail.mainSrc} onClick={()=> this.openImageModal(i)} />
                        <p id="text" onClick={()=>this.openImageModal(i)}>
                                +{eventDetail.remainingImages}<br></br>
                                {eventDetail.eventName}
                        </p>
                

                { 
                        eventDetail.open && (
                                
                                <Lightbox
                                
                                        mainSrc={eventDetail.images[eventDetail.index]}
                                        nextSrc={eventDetail.images[(eventDetail.index + 1) % eventDetail.images.length]}
                                        prevSrc={eventDetail.images[(eventDetail.index + eventDetail.images.length - 1) % eventDetail.images.length]}
                                        onCloseRequest={()=>this.closeImageModal(i)}
                                        imageTitle={eventDetail.titles[eventDetail.index]}
                                        onMovePrevRequest={() => this.gotoPreviousImage(i)}
                                        
                                        onMoveNextRequest={() => this.gotoNextImage(i)}
                                        clickOutsideToClose={this.state.eventData.clickOutsideToClose}
                                        discourageDownloads={this.state.eventData.discourageDownloads}
                                />
                        )
                }
                </div>
        )
}
openImageModal(i:number){
        var eventDataTemp = this.state.eventData;
        eventDataTemp.eventDetails[i].open = true;
         this.setState({eventData:eventDataTemp});
}
closeImageModal(i:number){
        var eventDataTemp = this.state.eventData;
        eventDataTemp.eventDetails[i].open = false;
         this.setState({eventData:eventDataTemp});
}
gotoPreviousImage(i:number){
        var eventDataTemp = this.state.eventData;
        eventDataTemp.eventDetails[i].index = (eventDataTemp.eventDetails[i].index + eventDataTemp.eventDetails[i].images.length-1)% eventDataTemp.eventDetails[i].images.length;
        this.setState({eventData:eventDataTemp});
}
gotoNextImage(i:number){
        var eventDataTemp = this.state.eventData;
        eventDataTemp.eventDetails[i].index = (eventDataTemp.eventDetails[i].index +1) % eventDataTemp.eventDetails[i].images.length;
        this.setState({eventData:eventDataTemp});
}
private _isMounted: boolean = false;
}