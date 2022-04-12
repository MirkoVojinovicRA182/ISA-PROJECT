export class AdventureReservation{
    id: number = -1;
    clientUsername: string = "";
    adventureName: string = "";
    startTime: Date = new Date();
    endTime: Date = new Date();
    bill: number = 0;
    finished: boolean = false;
}