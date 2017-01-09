import { Component, OnInit, AfterViewInit, ViewChild } from "@angular/core";
import { Work } from "../_models/work";
import { RequestSharedService } from "../_services/index";
import { Subscription }   from 'rxjs/Subscription';
import { NewWorkComponent } from "./new-work.component";

@Component({
    selector: 'works-table',
    moduleId: module.id,
    templateUrl: 'works.component.html'
})

export class WorksComponent {
    works: Work[];
    subscription: Subscription;

    @ViewChild('newWorkComponent')
    newWorkComponent: NewWorkComponent;

    constructor(private sharedService: RequestSharedService) {
        this.subscription = this.sharedService.works$
            .subscribe(works => {
                this.works = works
            });
    }

    createNewWork(): void {
        this.newWorkComponent.createNewWork();
    }
}