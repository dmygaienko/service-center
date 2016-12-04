import { NgModule, CUSTOM_ELEMENTS_SCHEMA }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule }    from '@angular/forms';
import { HttpModule } from '@angular/http';
import { ModalModule } from 'angular2-modal';
import { BootstrapModalModule } from 'angular2-modal/plugins/bootstrap';

// used to create fake backend
/*import { fakeBackendProvider } from './_helpers/index';*/
import { MockBackend, MockConnection } from '@angular/http/testing';
import { BaseRequestOptions } from '@angular/http';

import { AppComponent }  from './app.component';
import { routing }        from './app.routing';

import { AlertComponent } from './_directives/index';
import { AuthGuard } from './_guards/index';
import { AlertService, AuthenticationService, UserService, WorksSharedService, RequestService } from './_services/index';
import { HomeComponent } from './home/index';
import { RequestsComponent } from './requests/index';
import { RequestComponent } from './request/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { WorksComponent } from './works/index';
import { AboutComponent } from "./about/index";

import { MenuComponent } from "./menu/index";
import { EmployeesComponent } from "./employees/index";
import { NgSemanticModule } from 'ng-semantic';

@NgModule({
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        HttpModule,
        routing,
        NgSemanticModule,
        ModalModule.forRoot(),
        BootstrapModalModule
    ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        RequestsComponent,
        RequestComponent,
        MenuComponent,
        LoginComponent,
        RegisterComponent,
        WorksComponent,
        EmployeesComponent,
        AboutComponent
    ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        RequestService,
        WorksSharedService,

        // providers used to create fake backend
       /* fakeBackendProvider,*/
        MockBackend,
        BaseRequestOptions
    ],
    bootstrap: [AppComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})

export class AppModule { }
