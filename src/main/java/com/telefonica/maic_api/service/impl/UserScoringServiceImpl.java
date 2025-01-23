package com.telefonica.maic_api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telefonica.maic_api.dto.UserScoringDto;
import com.telefonica.maic_api.dto.mapper.DtoMapperUserScoring;
import com.telefonica.maic_api.entity.UserScoring;
import com.telefonica.maic_api.repository.UserScoringRepository;
import com.telefonica.maic_api.service.UserScoringService;


@Service
public class UserScoringServiceImpl implements UserScoringService {

    @Autowired
    private UserScoringRepository userScoringRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserScoringDto> findAll() {
        List<UserScoring> scorings = (List<UserScoring>) userScoringRepository.findAll();
        return scorings
                .stream()
                .map(s -> DtoMapperUserScoring.builder().setUserScoring(s).build())
                .toList();
    }

    @Override
    public Optional<UserScoring> findByNumTelefono(String numTelefono) {
        return userScoringRepository.findByNumTelefono(numTelefono);
    }
}
