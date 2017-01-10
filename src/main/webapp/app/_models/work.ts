import { UserInfo } from "./user-info";
export class Work {

    id: string;
    description: string;
    price: string;
    status: string;
    master: UserInfo;
    requestId: string


    constructor(description: string, price: string, status: string, master: UserInfo, requestId: string) {
        this.description = description;
        this.price = price;
        this.status = status;
        this.master = master;
        this.requestId = requestId;
    }
}