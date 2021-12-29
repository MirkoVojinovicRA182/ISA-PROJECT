import { defaultThrottleConfig } from "rxjs/internal/operators/throttle";

export class RegistrationRequest{
    requestDate: Date = new Date();
    name: string = "";
    lastName: string = "";
    userType: string = "";
    registrationExplanation: string = "";

}