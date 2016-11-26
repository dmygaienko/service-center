import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { RequestsComponent } from './requests/index';
import { RequestComponent } from './request/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { EmployeesComponent } from './employees/index';
import { AboutComponent } from './about/index';
import { AuthGuard } from './_guards/index';

const appRoutes: Routes = [
    { path: '',                 component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login',            component: LoginComponent },
    { path: 'requests',         component: RequestsComponent, canActivate: [AuthGuard] },
    { path: 'request/byId/:id', component: RequestComponent, canActivate: [AuthGuard] },
    { path: 'register',         component: RegisterComponent, canActivate: [AuthGuard] },
    { path: 'employees',        component: EmployeesComponent, canActivate: [AuthGuard] },
    { path: 'about',            component: AboutComponent, canActivate: [AuthGuard] },

    // otherwise redirect to home
    { path: '**',           redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);