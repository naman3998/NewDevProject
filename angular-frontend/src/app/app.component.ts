import { Component, OnInit } from '@angular/core';
import { AuthService } from './login/auth.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {

  constructor(private router: Router,private authService: AuthService){}
  title = '';
  loggedinUser: string = '';
  ngOnInit() {
    // this.isLoggedin = this.authService.isUserLoggedin();
    this.loggedinUser = this.authService.getLoggedInUserName();
  
  }

  doLogout() {
    this.authService.logout();
    this.router.navigateByUrl('login');
  }

  employeeDash(){
    this.router.navigateByUrl('employee-dashboard');
  }

  skillsDash(){
    this.router.navigateByUrl('skills-dashboard');
  }
  certificatesDash(){
    this.router.navigateByUrl('certificates-dashboard');
  }

  homeDash(){
    this.router.navigateByUrl('employees');
  }
}

