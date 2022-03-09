package com.mindtree.modules.certificates.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindtree.modules.certificates.entity.Certifcation;


@Service
public interface CertificationService {
	public List<Certifcation> getAllCertificates();
	public void setCertificate(Certifcation c);
	public Optional<Certifcation> searchById(Long id);
	public void delete_certification(Long id) ;
}
