package com.sut.se.cpe.server.repository;

import com.sut.se.cpe.server.entity.Medi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface MediRepository extends JpaRepository<Medi, Long>{

}
