///<reference path="../../node_modules/@angular/http/src/headers.d.ts"/>
import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map'

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
                // login successful if there's a jwt token in the response
                let user = response.json();
                if (user && user.token) {
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}
