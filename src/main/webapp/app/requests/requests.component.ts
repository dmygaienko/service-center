import { Component, OnInit } from "@angular/core";
import { RequestService } from "../_services/request.service";
import { Request } from "../_models/request";
import { Router } from "@angular/router";

@Component({
    moduleId: module.id,
    templateUrl: 'requests.component.html'
})

export class RequestsComponent implements OnInit {
    requests: Request[];

    constructor(private requestService: RequestService, private router: Router) {
    }

    ngOnInit(): void {
        this.requestService.getAll().subscribe(list => this.requests = list);
    }

    openRequest(request: Request): void {
        this.router.navigate(['/request/byId/' + request.id]);
    }
}