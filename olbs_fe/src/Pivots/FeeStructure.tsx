import React from 'react';
var Marquee = require('react-marquee');
import request from 'superagent';
import './FeeStructure.scss';

interface IFeeData{
    className: string;
    tuitionFee: number,
    annualFee:number,
    courseFee: number,
    examinationFee: number
}
interface IState {
    feeData: IFeeData[];
}

export class FeeStructure extends React.Component<{}, IState> {

    constructor(props: any) {
        super(props);
        this.state = {feeData: []};
    }
    public componentWillMount() {


        request
        .get('http://localhost:1208/OLBS/fees')
        .set('Content-Type','application/json')

        .set('Accept', 'application/json')
        .end((err, resp) => {
          if (!err) {
           this.setState({feeData: resp.body.feeData as IFeeData[]});
          }
        })
  }

    public render() {
        let renderedList: JSX.Element[] = [];
        if(this.state.feeData && this.state.feeData.length > 0) {
            this.state.feeData.forEach((fee) => {
                renderedList.push(this._getFeeRow(fee));
            })
        }
       
        return (
            <div className="fee-structure-container">
                <div className="fee-info">
                <div className={"marquee-container"}>
                    <Marquee
                        text="PLEASE NOTE: FEES TO BE PAID AT THE TIME OF PROMOTION TO NEXT HIGHER CLASS.  PLEASE NOTE:  FEES TO BE PAID AT THE TIME OF PROMOTION TO NEXT HIGHER CLASS."
                        loop={true}
                        hoverToStop={true}
                        leading={0}
                        trailing={0}>
                    </Marquee>
                    </div>
                </div>
                <table>
                    {renderedList}
                </table>
            </div>
        )
    }

    private _getFeeRow(feeDataPerClass: any): JSX.Element {
        return (
            <tbody className="row-conatiner" key={feeDataPerClass.className}>
                <tr className="table-row header-row">
                    <th className="table-column column-header">
                        <span>
                            {feeDataPerClass.className}
                        </span>
                    </th>
                    <th className="table-column column-header">
                        <span>
                            ANNUALLY
                        </span>
                    </th>
                    <th className="table-column column-header">
                        <span>
                            MONTHLY
                        </span>
                    </th>
                </tr>
                <tr className="table-row even-row">
                    <th className="table-column column-header">
                        <span>
                            TUITION FEE
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.tuitionFee * 12}
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.tuitionFee}
                        </span>
                    </th>
                </tr>
                <tr className="table-row odd-row">
                    <th className="table-column column-header">
                        <span>
                            ANNUAL FEE
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.annualFee}
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {}
                        </span>
                    </th>
                </tr>
                <tr className="table-row even-row">
                    <th className="table-column column-header">
                        <span>
                            COURSE FEE
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.courseFee * 12}
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.courseFee}
                        </span>
                    </th>
                </tr>
                <tr className="table-row odd-row">
                    <th className="table-column">
                        <span>
                            EXAMINATION FEE
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.examinationFee * 12}
                        </span>
                    </th>
                    <th className="table-column">
                        <span>
                            {feeDataPerClass.examinationFee}
                        </span>
                    </th>
                </tr>
            </tbody>
        );
    }
}