import { Component } from "@angular/core";
import { RequestSharedService } from "../_services/index";
import { Subscription } from "rxjs/Subscription";
import { DetailComponent } from "../_models/component";

@Component({
    selector: 'components-table',
    moduleId: module.id,
    templateUrl: 'components.component.html'
})

export class ComponentsComponent {
    components: DetailComponent[];
    subscription: Subscription;

    constructor(private sharedService: RequestSharedService) {
        this.subscription = this.sharedService.components$
            .subscribe(components => {
                this.components = components
            });
    }
}