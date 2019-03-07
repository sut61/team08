package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.Workday;

@RepositoryRestResource
public interface WorkdayRepository extends JpaRepository<Workday, Long> {
    Workday findById(long workdayId);
}
