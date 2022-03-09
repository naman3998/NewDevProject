import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmployeeComponent } from './create-employee/create-employee.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { SkillsDashboardComponent } from './skills-dashboard/skills-dashboard.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { EmployeeListComponent } from './employee-list/employee-list.component';
import { LoginComponent } from './login/login.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';
import { UpdateSkillComponent } from './update-skill/update-skill.component';
import { CertificatesComponent } from './certificates/certificates.component';
import { CertificatesDashboardComponent } from './certificates-dashboard/certificates-dashboard.component';


// ,redirectTo:'employees', pathMatch: 'full'
const routes: Routes = 
[
  {path:'employees' , component:EmployeeListComponent},
  {path: 'create-employee', component:CreateEmployeeComponent},
  // {path:'' , redirectTo:'login', pathMatch: 'full'},
  // {path:'' , redirectTo:'employees', pathMatch: 'full'},
  {path:'employee-dashboard', component:EmployeeDashboardComponent},
  {path:'#' ,redirectTo:'employees', pathMatch: 'full'},
  {path:'update-employee/:id', component:UpdateEmployeeComponent},
  {path:'employee-details/:id', component:EmployeeDetailsComponent},
  {path:'update-skill', component:UpdateSkillComponent},
  {path:'skills-dashboard', component:SkillsDashboardComponent},
  {path:'certificates-dashboard', component:CertificatesDashboardComponent},
  {path:'certificates', component:CertificatesComponent},
  {path: 'login', component: LoginComponent},
  {path: '', component: LoginComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
