package com.mindtree.modules.certificates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.modules.certificates.entity.Certifcation;
@Repository
public interface CertificationRepository extends JpaRepository<Certifcation,Long> {

}