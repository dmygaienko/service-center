import { Component, OnInit } from "@angular/core";
import { RequestService } from "../_services/request.service";
import { Request } from "../_models/request";
import { Router } from "@angular/router";
import { FormGroup, FormControl, FormBuilder } from "@angular/forms";

@Component({
    moduleId: module.id,
    templateUrl: 'requests.component.html'
})

export class RequestsComponent implements OnInit {
    searchForm: FormGroup;
    requests: Request[];

    constructor(private requestService: RequestService, private router: Router, fb: FormBuilder) {
        this.searchForm = fb.group({
            'surnameControl': new FormControl('', ),
            'idControl': new FormControl('', ),
            'makerControl': new FormControl('', ),
            'productControl': new FormControl('', ),
        });

    }

    ngOnInit(): void {
        this.requestService.getAll().subscribe(list => this.requests = list);
    }

    openRequest(request: Request): void {
        this.router.navigate(['/request/byId/' + request.id]);
    }

    search(): void {

    }
}