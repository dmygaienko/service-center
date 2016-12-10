import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, AuthenticationService } from '../_services/index';
import { FormGroup, FormBuilder, Validators, FormControl } from "@angular/forms";

@Component({
    moduleId: module.id,
    templateUrl: 'login.component.html'
})

export class LoginComponent implements OnInit {
    loginForm: FormGroup;
    loading = false;
    formSubmitted = false;

    constructor(
        formBuilder: FormBuilder,
        private router: Router,
        private authenticationService: AuthenticationService,
        private alertService: AlertService)
    {
        this.loginForm = formBuilder.group({
            'emailControl': new FormControl('', Validators.compose([
                Validators.required, Validators.minLength(4),
                Validators.pattern('^[a-z0-9]+(\.[_a-z0-9]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,15})$'),
            ])),
            'passwordControl': new FormControl('', Validators.compose([Validators.required, Validators.minLength(8)])),
            'agreeControl': new FormControl(true, Validators.required),
        });
    }

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
    }

    login() {
        if (!this.loginForm.valid) return;

        this.loading = true;
        this.authenticationService.login(this.loginForm.value.emailControl, this.loginForm.value.passwordControl)
            .subscribe(
                data => {
                    this.router.navigate(['/']);
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
