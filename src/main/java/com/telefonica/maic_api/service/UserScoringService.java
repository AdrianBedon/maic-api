package com.telefonica.maic_api.service;

import java.util.List;
import java.util.Optional;

import com.telefonica.maic_api.dto.UserScoringDto;
import com.telefonica.maic_api.entity.UserScoring;

public interface UserScoringService {
    List<UserScoringDto> findAll();

    Optional<UserScoring> findByNumTelefono(String numTelefono);
}
