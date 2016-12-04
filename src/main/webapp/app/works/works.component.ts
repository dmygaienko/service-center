import { Component, OnInit, AfterViewInit } from "@angular/core";
import { Work } from "../_models/work";
import { WorksSharedService } from "../_services/works-shared.service";
import { Subscription }   from 'rxjs/Subscription';

@Component({
    selector: 'works-table',
    moduleId: module.id,
    templateUrl: 'works.component.html'
})

export class WorksComponent {
    works: Work[];
    subscription: Subscription;

    constructor(private sharedService: WorksSharedService) {
        this.subscription = this.sharedService.works$
            .subscribe(works => {
                this.works = works
            });
    }
}