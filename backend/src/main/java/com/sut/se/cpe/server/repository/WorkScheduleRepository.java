package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.WorkSchedule;

@RepositoryRestResource
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long>{
	WorkSchedule findById(long scheduleId);
}
