import { Component, OnInit, AfterViewInit, ViewChild } from "@angular/core";
import { Work } from "../_models/work";
import { RequestSharedService } from "../_services/index";
import { Subscription }   from 'rxjs/Subscription';
import { NewWorkComponent } from "./new-work.component";
import { RequestDetails } from "../_models/request-details";

@Component({
    selector: 'works-table',
    moduleId: module.id,
    templateUrl: 'works.component.html'
})

export class WorksComponent {

    requestSubscription: Subscription;
    requestDetails: RequestDetails;

    works: Work[];
    worksSubscription: Subscription;

    @ViewChild('newWorkComponent')
    newWorkComponent: NewWorkComponent;

    constructor(private sharedService: RequestSharedService) {
        this.worksSubscription = this.sharedService.works$
            .subscribe(works => {
                this.works = works
            })
            ;

        this.requestSubscription = this.sharedService.request$
            .subscribe(requestDetails => {
                this.requestDetails = requestDetails
            })
        ;
    }

    createNewWork(): void {
        this.newWorkComponent.createNewWork();
    }
}