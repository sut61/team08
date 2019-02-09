package com.sut.se.cpe.server.repository;

import com.sut.se.cpe.server.entity.Patient;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface PatientRepository extends JpaRepository<Patient, Long> {
}