import { Injectable } from "@angular/core";
import { Http, Headers, RequestOptions, Response } from "@angular/http";
import { Work } from "../_models/work";


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

import { Observable } from 'rxjs';


@Injectable()
export class WorkService {
    constructor(private http: Http) {
    }

    create(work: Work) : Observable<string> {
        let headers      = new Headers({ 'Content-Type': 'application/json' }); // ... Set content type to JSON
        let options       = new RequestOptions({ headers: headers });

        return this.http.post('/api/works/create', work, options)
            .map((res:Response) => res.json())
          //  .catch((error:any) => Observable.throw(error.json().error || 'Server error'))
        ;
    }

}
