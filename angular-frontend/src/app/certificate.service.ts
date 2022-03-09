import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Certificate } from './certificate';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {

  private baseUrl = "http://localhost:8080/certificates";
  constructor(private httpClient : HttpClient) { }
  createEmployee(employee : Certificate): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`, employee);
  }
  getCertificateById(id: number): Observable<Certificate>
  {
    return this.httpClient.get<Certificate>(`${this.baseUrl}/${id}`);
  }

  createCertificate(certificate : Certificate): Observable<Object>{
    return this.httpClient.post(`${this.baseUrl}`, certificate);
  }

  getCertificatesList() : Observable<Certificate[]>{
    return this.httpClient.get<Certificate[]>(`${this.baseUrl}`);
  }





}