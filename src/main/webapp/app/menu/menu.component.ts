import {Component} from "@angular/core";
import {AuthenticationService} from "../_services/index";

@Component({
    moduleId: module.id,
    selector: 'app-menu',
    templateUrl: 'menu.component.html'
})

export class MenuComponent {

    constructor(private authenticationService: AuthenticationService) {}

    isAuthenticated() {
        return this.authenticationService.isAuthenticated();
    }

    hasRole(role:string){
        return this.authenticationService.hasRole(role);
    }
}