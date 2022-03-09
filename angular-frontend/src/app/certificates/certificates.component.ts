import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Certificate } from '../certificate';
import { CertificateService } from '../certificate.service';

@Component({
  selector: 'app-certificates',
  templateUrl: './certificates.component.html',
  styleUrls: ['./certificates.component.css']
})
export class CertificatesComponent implements OnInit {

  certificate: Certificate=new Certificate();
  constructor(private certificatesService: CertificateService,
    private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.router.navigate(['/employees']);
  }

  // onSubmit(){
  //   console.log(this.certificate);
  //   this.saveCertificates();
  // }
  saveCertificates(){
    this.certificatesService.createCertificate(this.certificate).subscribe( data =>{
      console.log(data);
      this.goToEmployeeList();
    },
    error => console.log(error));
  }
  goToEmployeeList(){
    this.router.navigate(['/employees']);
  }

}


