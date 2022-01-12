export class Reservation{
    id: number = -1;
    clientUsername: string = "";
    adventureName: string = "";
    startTime: Date = new Date();
    endTime: Date = new Date();
    finished: boolean = false;
}