package com.telefonica.maic_api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.telefonica.maic_api.entity.UserNB;

public interface UserNBRepository extends CrudRepository<UserNB, Long> {
    List<UserNB> findByNumTelefono(String numTelefono);
}
