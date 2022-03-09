package com.mindtree.modules.certificates.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.modules.certificates.entity.Certifcation;
import com.mindtree.modules.certificates.repository.CertificationRepository;

@Service
public class CertificateServiceImple implements CertificationService {

	@Autowired
	public CertificationRepository repo;
	
	@Override
	public List<Certifcation> getAllCertificates() {
		return repo.findAll();
	}

	@Override
	public void setCertificate(Certifcation c) {
		repo.save(c);
		
	}

	@Override
	public Optional<Certifcation> searchById(Long id) {
		return repo.findById(id);
	}

	public void delete_certification(Long id) {
		repo.deleteById(id);
	}

}