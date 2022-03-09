import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Certificate } from '../certificate';
import { Employee } from '../employee'
import { EmployeeService } from '../employee.service';
import { AuthService } from '../login/auth.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  isLoggedin = false;
  employees: Employee[] = []; 
  certificates: Certificate[] = [];
 

  // loggedinUser: string = '';


  

  constructor(private employeeService: EmployeeService,
    private route: ActivatedRoute,private http: HttpClient, private authService: AuthService,
    public router: Router) { }

  ngOnInit() {
   
    this.isLoggedin = this.authService.isUserLoggedIn();
    this.getEmployees();

    if(!this.isLoggedin) {
			this.router.navigateByUrl('login');
		}
this.getEmployees();


    // this.http.get('http://localhost:8080/employees').subscribe((data: Employee[]) => {
    //   this.employees = data;});
  }



  private getEmployees(){

    this.employeeService.getEmployeesList().subscribe((data: Employee[]) => {
      this.employees = data;
    });
  }

  updateEmployee(id: number){
    this.router.navigate(['update-employee',id]);
  }

  deleteEmployee(id: number){
    this.employeeService.deleteEmployee(id).subscribe(data => {
      console.log(data);
      this.getEmployees();
    })

  }

  employeeDetails(id: number){
    this.router.navigate(['employee-details',id]);

  }

  // doLogout() {
	// 	this.authService.logout();
	// 	this.router.navigateByUrl('login');
	// }

  //  employeeDash(){
  //   this.router.navigateByUrl('employee-dashboard');
  // }

  // onClick(){
  //   this.router.navigate(['/employees']);
  // }

}
