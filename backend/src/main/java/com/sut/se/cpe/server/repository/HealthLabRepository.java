package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.HealthLab;

@RepositoryRestResource
public interface HealthLabRepository extends JpaRepository<HealthLab, Long> {
    HealthLab findById(long sid);
}
