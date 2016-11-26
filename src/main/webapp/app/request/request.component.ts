import { Component, OnInit } from "@angular/core";
import { Request } from "../_models/request";
import { RequestService } from "../_services/request.service";
import { ActivatedRoute, Params } from "@angular/router";
import "rxjs/add/operator/switchMap";

@Component({
    moduleId: module.id,
    templateUrl: 'request.component.html'
})

export class RequestComponent implements OnInit {
    request: Request;

    constructor(
        private requestService: RequestService,
        private route: ActivatedRoute) {
    }

    ngOnInit(): void {
        this.route.params
            .switchMap((params: Params) => this.requestService.getById(params['id']))
            .subscribe(request => this.request = request);
    }

}