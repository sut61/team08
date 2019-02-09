package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.HealthProgram;

@RepositoryRestResource
public interface HealthProgramRepository extends JpaRepository<HealthProgram, Long> {
    HealthProgram findById(long programId);
}
