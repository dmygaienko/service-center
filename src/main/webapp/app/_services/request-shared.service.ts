import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs/BehaviorSubject";
import { Observable } from "rxjs";
import { Work, DetailComponent } from "../_models/index";
import { RequestDetails } from "../_models/request-details";

@Injectable()
export class RequestSharedService {


    // Observable string sources
    private requestSource = new BehaviorSubject<RequestDetails>(null);
    private worksSource = new BehaviorSubject<Work[]>(null);
    private componentsSource = new BehaviorSubject<DetailComponent[]>(null);

    request$: Observable<RequestDetails> = this.requestSource.asObservable();
    works$: Observable<Work[]> = this.worksSource.asObservable();
    components$: Observable<DetailComponent[]> = this.componentsSource.asObservable();

    addRequest(request: RequestDetails) {
        this.requestSource.next(request);
    }

    addWorks(works: Work[]) {
        this.worksSource.next(works);
    }

    addComponents(components: DetailComponent[]) {
        this.componentsSource.next(components);
    }

}