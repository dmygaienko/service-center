import { Component, OnInit, ViewChild } from "@angular/core";
import { RequestService } from "../_services/request.service";
import { ActivatedRoute, Params } from "@angular/router";
import "rxjs/add/operator/switchMap";
import { RequestDetails } from "../_models/request-details";
import { Image } from "../_models/image";
import { SemanticModalComponent } from "ng-semantic";

@Component({
    moduleId: module.id,
    templateUrl: 'request.component.html'
})

export class RequestComponent implements OnInit {
    selectedImage: Image;
    request: RequestDetails;

    @ViewChild("bigImageModal")
    imageModal: SemanticModalComponent;

    constructor(private requestService: RequestService,
                private route: ActivatedRoute) { }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.requestService.getById(params['id']))
            .subscribe(requestDetails => this.request = requestDetails);
    }

    showModal(image: Image): void {
        this.selectedImage = image;
        this.imageModal.show();
    }

}