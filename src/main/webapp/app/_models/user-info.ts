export class UserInfo {

    id: string;
    email: string;
    username: string;
    surname: string;
    authorities: string[];

    constructor(id: string) {
        this.id = id;
    }
}