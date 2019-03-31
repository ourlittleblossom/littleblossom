import React, { Component } from 'react';
import { Home } from "./Pivots/Home";
import { FeeStructure } from "./Pivots/FeeStructure";
import { Gallery } from "./Pivots/Gallery";
import { ContactUs } from "./Pivots/ContactUs";
import { About } from "./Pivots/About";

import logo from "./logo.png";
import './LandingPage.scss';

export interface IState {
    selectedKey: string;
}

export interface IProps {
}

const KeyName = {
    home: "Home",
    gallery: "Gallery",
    feeStructure: "Fee structure",
    contactUs: "Contact Us",
    about: "About"
}

export class LandingPage extends React.Component<IProps, IState> {
    constructor(props: any) {
        super(props);
        this.state = { selectedKey: KeyName.home };
    }

    render() {
        return (
            <div className={"parent-page"}>
                <div className="logo-pivot-container">
                    <img src={logo} className="logo" alt="logo" />
                    <div className="pivot-container">
                        <button className="pivot-item" onClick={(ev) => { this._onSelectionChange(KeyName.home) }}>{KeyName.home}</button>
                        <button className="pivot-item" onClick={(ev) => { this._onSelectionChange(KeyName.about) }}>{KeyName.about}</button>
                        <button className="pivot-item" onClick={(ev) => { this._onSelectionChange(KeyName.gallery) }}>{KeyName.gallery}</button>
                        <button className="pivot-item" onClick={(ev) => { this._onSelectionChange(KeyName.feeStructure) }}>{KeyName.feeStructure}</button>
                        <button className="pivot-item" onClick={(ev) => { this._onSelectionChange(KeyName.contactUs) }}>{KeyName.contactUs}</button>
                    </div>
                </div>
                <div className="pivot-content">
                    {this._getSelectedPivotContent()}
                </div>
            </div>
        );
    }

    private _onSelectionChange = (keyName: string): void => {
        this.setState({ selectedKey: keyName });
    }

    private _getSelectedPivotContent(): JSX.Element {
        switch (this.state.selectedKey) {
            case KeyName.home:
                return (<Home />);

            case KeyName.about:
                return (<About />);

            case KeyName.gallery:
                return (<Gallery />);

            case KeyName.feeStructure:
                return (<FeeStructure />);

            case KeyName.contactUs:
                return (<ContactUs />);

            default:
                return (<div />);
        }
    }
}