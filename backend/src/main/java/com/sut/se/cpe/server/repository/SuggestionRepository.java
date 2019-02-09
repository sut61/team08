package com.sut.se.cpe.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.sut.se.cpe.server.entity.Suggestion;

@RepositoryRestResource
public interface SuggestionRepository extends JpaRepository<Suggestion, Long>{
	Suggestion findById(long suggestionId);
}
