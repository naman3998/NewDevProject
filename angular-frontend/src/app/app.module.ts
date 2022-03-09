import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import{FormsModule} from '@angular/forms';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { UpdateSkillComponent } from './update-skill/update-skill.component';
import { LoginComponent } from './login/login.component';
import { HttpInterceptorService } from './http-interceptor.service';

import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { SkillsDashboardComponent } from './skills-dashboard/skills-dashboard.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { CertificatesDashboardComponent } from './certificates-dashboard/certificates-dashboard.component';

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    CreateEmployeeComponent,
    UpdateEmployeeComponent,
    EmployeeDetailsComponent,
    UpdateSkillComponent,
    LoginComponent,
 
    EmployeeDashboardComponent,
    SkillsDashboardComponent,
    CertificatesComponent,
    CertificatesDashboardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
