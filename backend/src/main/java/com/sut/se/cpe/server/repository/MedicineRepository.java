package com.example.demo.repository;
import com.example.demo.entity.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
@RepositoryRestController
@RepositoryRestResource
@EnableJpaRepositories
@CrossOrigin(origins = "http://localhost:4200")
public 
interface MedicineRepository extends JpaRepository<Medicine, Long>{
    
}