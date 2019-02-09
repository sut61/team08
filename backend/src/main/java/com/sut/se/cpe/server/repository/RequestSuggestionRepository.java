package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.RequestSuggestion;

@RepositoryRestResource
public interface RequestSuggestionRepository extends JpaRepository<RequestSuggestion, Long> {
    RequestSuggestion findById(long RequestSuggestionId);
}
