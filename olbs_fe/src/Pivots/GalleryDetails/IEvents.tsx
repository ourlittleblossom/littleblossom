import {IEventDetails} from './IEventDetails';
export interface IEvents{
    discourageDownloads : boolean;
    clickOutsideToClose : boolean;
    eventDetails : IEventDetails[];
}