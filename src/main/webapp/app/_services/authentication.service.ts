///<reference path="../../node_modules/@angular/http/src/headers.d.ts"/>
import { Injectable } from "@angular/core";
import { Http, Headers, Response } from "@angular/http";
import "rxjs/add/operator/map";
import { User } from "../_models/user";

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }

    login(username, password) {
        var headers = new Headers();
        /*headers.append('Content-Type', 'application/json');*/
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        headers.append('X-Requested-With', 'XMLHttpRequest');

      /*  return this.http.post('/login', JSON.stringify({ username: username, password: password }),*/
        return this.http.post('/login', "username=" + username + "&password=" + password, {headers})
            .map((response: Response) => {
                if (response) {
                    let user = response.json();
                    if (user != 'undefined' && user.authenticated) {
                        sessionStorage.setItem('currentUser', JSON.stringify(user));
                    } else {
                        throw new Error("Bad credentials");
                    }
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        this.http.post('/logout', {})
            .subscribe(response => sessionStorage.removeItem('currentUser'));
        ;
    }

    isAuthenticated() {
        var sessionUser = sessionStorage.getItem('currentUser');

        if (sessionUser) {
            return JSON.parse(sessionUser).authenticated;
        } else {
            return false;
        }
    }

    getCurrentUser() {
        return JSON.parse(sessionStorage.getItem('currentUser'));
    }

    hasRole(role:string) {
        var user = JSON.parse(sessionStorage.getItem('currentUser')) as User;
        return user.authorities.includes(role);
    }
}
