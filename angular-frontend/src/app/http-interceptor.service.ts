import { HttpEvent, HttpHeaders ,HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthService } from './login/auth.service';

@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor{

  constructor(private authService: AuthService) { }


  // intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  //   const request = req.clone({withCredentials: true});
  //   return next.handle(request);
  // }





  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
  if (this.authService.isUserLoggedIn() && req.url.indexOf('basicauth') === -1) {
            const request = req.clone({
                headers: new HttpHeaders({
                    'Content-Type': 'application/json',
                    'Authorization': `Basic ${window.btoa(this.authService.username + ":" + this.authService.password)}`
                })
            });
            return next.handle(request);
        }
        return next.handle(req);   
  }
  
}
