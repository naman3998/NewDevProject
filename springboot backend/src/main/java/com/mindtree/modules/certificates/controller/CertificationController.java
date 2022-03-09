package com.mindtree.modules.certificates.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.modules.certificates.entity.Certifcation;
import com.mindtree.modules.certificates.service.CertificationService;


//
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
@RestController
public class CertificationController {

	@Autowired
	public CertificationService certificateService;
	
	
	@PostMapping("/certificates")
	public void add_certificate(@RequestBody Certifcation e)
	{
		certificateService.setCertificate(e);
	}
	
	@GetMapping("/certificates")
	
	public ResponseEntity<List<Certifcation>> getAllcertificates()
	{
		return ResponseEntity.ok(certificateService.getAllCertificates());
	}

	@GetMapping("/certificates/{id}")
	public Optional<Certifcation> getById(@PathVariable Long id)
	{
		return certificateService.searchById(id);
	}
	
	@DeleteMapping("/certificates/{id}")
	public void delete_certification(@PathVariable Long id)
	{
		certificateService.delete_certification(id);
	}
}
