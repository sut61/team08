package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.StaffPosition;

@RepositoryRestResource
public interface StaffPositionRepository extends JpaRepository<StaffPosition, Long> {
    StaffPosition findById(long staffPositId);
}
