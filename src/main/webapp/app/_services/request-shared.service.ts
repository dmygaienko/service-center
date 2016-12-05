import { Injectable } from "@angular/core";
import { BehaviorSubject } from "rxjs/BehaviorSubject";
import { Observable } from "rxjs";
import { Work, DetailComponent } from "../_models/index";

@Injectable()
export class RequestSharedService {

    // Observable string sources
    private worksSource = new BehaviorSubject<Work[]>(null);
    private componentsSource = new BehaviorSubject<DetailComponent[]>(null);

    works$: Observable<Work[]> = this.worksSource.asObservable();
    components$: Observable<DetailComponent[]> = this.componentsSource.asObservable();

    addWorks(works: Work[]) {
        this.worksSource.next(works);
    }

    addComponents(components: DetailComponent[]) {
        this.componentsSource.next(components);
    }

}