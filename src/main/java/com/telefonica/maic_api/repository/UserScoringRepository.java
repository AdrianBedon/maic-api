package com.telefonica.maic_api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.telefonica.maic_api.entity.UserScoring;

public interface UserScoringRepository extends CrudRepository<UserScoring, Long> {
    Optional<UserScoring> findByNumTelefono(String numTelefono);
}
