import { Component, OnInit } from "@angular/core";
import { RequestService } from "../_services/request.service";
import { Request } from "../_models/request";

@Component({
    moduleId: module.id,
    templateUrl: 'requests.component.html'
})

export class RequestsComponent implements OnInit {
    requests: Request[];

    constructor(private requestService: RequestService) {
    }

    ngOnInit(): void {
        this.requestService.getAll().subscribe(list => this.requests = list);
    }

}