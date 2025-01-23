package com.telefonica.maic_api.service;

import java.util.List;

import com.telefonica.maic_api.entity.UserNB;

public interface UserNBService {
    List<UserNB> findByNumTelefono(String numTelefono);
    UserNB save(Long id,UserNB userNB);
}
