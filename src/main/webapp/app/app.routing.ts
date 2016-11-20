import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './home/index';
import { RequestsComponent } from './requests/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { EmployeesComponent } from './employees/index';
import { AboutComponent } from './about/index';
import { AuthGuard } from './_guards/index';

const appRoutes: Routes = [
    { path: '',             component: HomeComponent, canActivate: [AuthGuard] },
    { path: 'login',        component: LoginComponent },
    { path: 'requests',     component: RequestsComponent },
    { path: 'register',     component: RegisterComponent },
    { path: 'employees',    component: EmployeesComponent },
    { path: 'about',        component: AboutComponent },

    // otherwise redirect to home
    { path: '**',           redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);