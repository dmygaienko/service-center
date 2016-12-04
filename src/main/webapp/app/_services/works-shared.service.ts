import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs/BehaviorSubject";
import { Observable } from "rxjs";
import { Work } from "../_models/work";

@Injectable()
export class WorksSharedService {

    // Observable string sources
    private worksSource = new BehaviorSubject<Work[]>(null);

    works$: Observable<Work[]> = this.worksSource.asObservable();

    addWorks(works: Work[]) {
        this.worksSource.next(works);
    }

}