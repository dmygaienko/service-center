import { Component, OnInit, AfterViewInit } from "@angular/core";
import { Work } from "../_models/work";
import { RequestSharedService } from "../_services/index";
import { Subscription }   from 'rxjs/Subscription';

@Component({
    selector: 'works-table',
    moduleId: module.id,
    templateUrl: 'works.component.html'
})

export class WorksComponent {
    works: Work[];
    subscription: Subscription;

    constructor(private sharedService: RequestSharedService) {
        this.subscription = this.sharedService.works$
            .subscribe(works => {
                this.works = works
            });
    }
}