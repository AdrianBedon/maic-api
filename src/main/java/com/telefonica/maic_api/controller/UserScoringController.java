package com.telefonica.maic_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonica.maic_api.dto.UserScoringDto;
import com.telefonica.maic_api.entity.UserNB;
import com.telefonica.maic_api.entity.UserScoring;
import com.telefonica.maic_api.service.UserNBService;
import com.telefonica.maic_api.service.UserScoringService;

@RestController
@RequestMapping("/api/scoring")
@CrossOrigin(origins = {"http://localhost:5173" })
public class UserScoringController {

    @Autowired
    private UserScoringService scoringService;

    @Autowired
    private UserNBService nbService;

    @GetMapping
    public List<UserScoringDto> findAll() {
        return scoringService.findAll();
    }

    @GetMapping("/{numTelefono}")
    public ResponseEntity<?> findUser(@PathVariable String numTelefono) {
        Optional<UserScoring> userOptional = scoringService.findByNumTelefono(numTelefono);

        if(userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.orElseThrow());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/nba-nbc/{numTelefono}")
    public List<UserNB> findUserNB(@PathVariable String numTelefono) {
        return nbService.findByNumTelefono(numTelefono);
    }

    @PutMapping("/nba-nbc/{id}")
    public ResponseEntity<?> updateUserScoring(@PathVariable Long id, @RequestBody UserNB updatedNb) {
        UserNB update = nbService.save(id, updatedNb);

        if (update != null) {
            return ResponseEntity.ok(update);
        }

        return ResponseEntity.notFound().build();
    }
}
