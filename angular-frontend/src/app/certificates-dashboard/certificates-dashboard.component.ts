import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Certificate } from '../certificate';
import { CertificateService } from '../certificate.service';

@Component({
  selector: 'app-certificates-dashboard',
  templateUrl: './certificates-dashboard.component.html',
  styleUrls: ['./certificates-dashboard.component.css']
})
export class CertificatesDashboardComponent implements OnInit {

  constructor( private certificateService: CertificateService, public router: Router) { }
  certificates: Certificate[]=[{certificateId:1, certificateName:"Java Certificate",certificateDesc:""},
  {certificateId:2, certificateName:"Python Certificate",certificateDesc:""},
  {certificateId:3, certificateName:"Angular Certificate",certificateDesc:""},
  {certificateId:4, certificateName:"Data-Structures",certificateDesc:""},
  {certificateId:5, certificateName:"Machine Learning",certificateDesc:""},
  {certificateId:6, certificateName:"Neural Networking",certificateDesc:""}];
  // certificate: any[]=[]
  
  ngOnInit(): void {
   
  }


  // this.getAllCertificates();

  // getAllCertificates()
  // {
  //   this.certificateService.getCertificatesList().subscribe(data => {
  //     this.certificates = data;
  //     console.log(data);
  //   });
  // }
}



