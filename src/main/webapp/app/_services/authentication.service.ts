///<reference path="../../node_modules/@angular/http/src/headers.d.ts"/>
import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'
import {User} from "../_models/user";

@Injectable()
export class AuthenticationService {
    constructor(private http: Http) { }


    login(username, password) {
        var headers = new Headers();
        /*headers.append('Content-Type', 'application/json');*/
        headers.append('Content-Type', 'application/x-www-form-urlencoded');
        headers.append('X-Requested-With', 'XMLHttpRequest');

      /*  return this.http.post('/login', JSON.stringify({ username: username, password: password }),*/
        return this.http.post('/login', "username=" + username + "&password=" + password,
            { headers })
            .map((response: Response) => {
                if(response) {
                    let user = response.json();
                    if (user != 'undefined' && user.authenticated) {
                        // store user details and jwt token in local storage to keep user logged in between page refreshes
                        localStorage.setItem('currentUser', JSON.stringify(user));
                    } else {
                        throw new Error("Bad credentials");
                    }
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }

    isAuthenticated() {
        return localStorage.getItem('currentUser') != null;
    }

    getCurrentUser() {
        return JSON.parse(localStorage.getItem('currentUser'));
    }

    hasRole(role:string) {
        var user = JSON.parse(localStorage.getItem('currentUser')) as User;
        return user.authorities.includes(role);
    }
}
