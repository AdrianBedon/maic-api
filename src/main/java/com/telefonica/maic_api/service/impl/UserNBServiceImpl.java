package com.telefonica.maic_api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.maic_api.entity.UserNB;
import com.telefonica.maic_api.repository.UserNBRepository;
import com.telefonica.maic_api.service.UserNBService;

@Service
public class UserNBServiceImpl implements UserNBService{

    @Autowired
    private UserNBRepository userNBRepository;

    @Override
    public List<UserNB> findByNumTelefono(String numTelefono) {
        return userNBRepository.findByNumTelefono(numTelefono);
    }

    @Override
    public UserNB save(Long id, UserNB userNB) {
        if (userNBRepository.findById(id).isPresent()) {
            return userNBRepository.save(userNB);
        }
        return null;
    }

}
