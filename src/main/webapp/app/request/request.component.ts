import { Component, OnInit, ViewContainerRef, ViewEncapsulation } from "@angular/core";
import { RequestService } from "../_services/request.service";
import { ActivatedRoute, Params } from "@angular/router";
import "rxjs/add/operator/switchMap";
import { RequestDetails } from "../_models/request-details";
import { Image } from "../_models/image";

import { Overlay } from 'angular2-modal';
import { Modal } from 'angular2-modal/plugins/bootstrap';

@Component({
    moduleId: module.id,
    templateUrl: 'request.component.html'
})

export class RequestComponent implements OnInit {
    request: RequestDetails;

    constructor(private requestService: RequestService,
                private route: ActivatedRoute,
                overlay: Overlay,
                vcRef: ViewContainerRef,
                public modal: Modal) {
        overlay.defaultViewContainer = vcRef;
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.requestService.getById(params['id']))
            .subscribe(requestDetails => this.request = requestDetails);
    }

    onClick(image: Image): void {
        this.modal.alert()
            .size('lg')
            .showClose(true)
            .title('A simple Alert style modal window')
            .body('<h4>Alert is a classic (title/body/footer) 1 button modal window that' +
                'does not block.</h4>' +
                '<b>Configuration:</b>').open();
    }

}