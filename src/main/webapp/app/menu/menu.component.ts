import {Component} from "@angular/core";
import {AuthenticationService} from "../_services/index";

@Component({
    moduleId: module.id,
    selector: 'app-menu',
    templateUrl: 'menu.component.html'
})

export class MenuComponent {
    menuItems = [
        new MenuComponent.Menu('home', 'Home'),
        new MenuComponent.Menu('requests', 'Requests'),
        new MenuComponent.Menu('employees', 'Our Employees'),
        new MenuComponent.Menu('about', 'About')
    ];

    activeMenu = this.menuItems[0];

    constructor(private authenticationService: AuthenticationService) {}

    isAuthenticated() {
        return this.authenticationService.isAuthenticated();
    }

    hasRole(role:string){
        return this.authenticationService.hasRole(role);
    }

    isActive(i:number): boolean {
        return this.activeMenu === this.menuItems[i];
    }

    setActive(i:number) {
        this.activeMenu = this.menuItems[i];
    }

    static Menu = class {
        route;
        description;

        constructor(route:string, description:string) {
            this.route = route;
            this.description = description;
        }
    }

}