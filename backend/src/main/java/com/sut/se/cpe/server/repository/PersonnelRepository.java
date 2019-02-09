package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.Personnel;

@RepositoryRestResource
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {
    Personnel findById(long personnelId);
}
