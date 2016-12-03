import { Injectable } from "@angular/core";
import { Http, Response } from "@angular/http";
import { Observable } from "rxjs";
import { Request } from "../_models/request";
import { RequestDetails } from "../_models/index";

@Injectable()
export class RequestService {
    constructor(private http: Http) {
    }

    getAll(): Observable<Request[]> {
        return this.http.get('/request/getAll').map((response: Response) => <Request[]> response.json());
    }

    getById(id: number | string): Observable<RequestDetails> {
        return this.http.get('/request/byId/' + id).map((response: Response) => <RequestDetails> response.json());
    }

}
