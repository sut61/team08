package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.Worktime;

@RepositoryRestResource
public interface WorktimeRepository extends JpaRepository<Worktime, Long> {
    Worktime findById(long worktimeId);
}
