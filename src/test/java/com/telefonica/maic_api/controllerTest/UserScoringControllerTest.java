package com.telefonica.maic_api.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.telefonica.maic_api.dto.UserScoringDto;
import com.telefonica.maic_api.entity.UserNB;
import com.telefonica.maic_api.entity.UserScoring;
import com.telefonica.maic_api.service.UserNBService;
import com.telefonica.maic_api.service.UserScoringService;
import com.telefonica.maic_api.controller.UserScoringController;

@ExtendWith(MockitoExtension.class)
public class UserScoringControllerTest {

    @Mock
    private UserScoringService scoringService;

    @Mock
    private UserNBService nbService;

    @InjectMocks
    private UserScoringController userScoringController;

    private UserScoring userScoring;
    private UserScoringDto userScoringDto;
    private UserNB userNB;

    @BeforeEach
    public void setUp() {
        userScoring = new UserScoring();
        userScoring.setNumTelefono("123456789");

        userScoringDto = new UserScoringDto();
        userScoringDto.setNumTelefono("123456789");

        userNB = new UserNB();
        userNB.setNumTelefono("123456789");
    }

    @Test
    public void testFindAll() {
        List<UserScoringDto> userScoringDtos = Arrays.asList(userScoringDto);
        when(scoringService.findAll()).thenReturn(userScoringDtos);

        List<UserScoringDto> result = userScoringController.findAll();

        assertEquals(userScoringDtos, result);
        verify(scoringService, times(1)).findAll();
    }

    @Test
    public void testFindUser() {
        when(scoringService.findByNumTelefono("123456789")).thenReturn(Optional.of(userScoring));

        ResponseEntity<?> response = userScoringController.findUser("123456789");

        assertEquals(ResponseEntity.ok(userScoring), response);
        verify(scoringService, times(1)).findByNumTelefono("123456789");
    }

    @Test
    public void testFindUser_NotFound() {
        when(scoringService.findByNumTelefono("123456789")).thenReturn(Optional.empty());

        ResponseEntity<?> response = userScoringController.findUser("123456789");

        assertEquals(ResponseEntity.notFound().build(), response);
        verify(scoringService, times(1)).findByNumTelefono("123456789");
    }

    @Test
    public void testFindUserNB() {
        List<UserNB> userNBs = Arrays.asList(userNB);
        when(nbService.findByNumTelefono("123456789")).thenReturn(userNBs);

        List<UserNB> result = userScoringController.findUserNB("123456789");

        assertEquals(userNBs, result);
        verify(nbService, times(1)).findByNumTelefono("123456789");
    }

    @Test
    public void testUpdateUserScoring() {
        when(nbService.save(1L, userNB)).thenReturn(userNB);

        ResponseEntity<?> response = userScoringController.updateUserScoring(1L, userNB);

        assertEquals(ResponseEntity.ok(userNB), response);
        verify(nbService, times(1)).save(1L, userNB);
    }

    @Test
    public void testUpdateUserScoring_NotFound() {
        when(nbService.save(1L, userNB)).thenReturn(null);

        ResponseEntity<?> response = userScoringController.updateUserScoring(1L, userNB);

        assertEquals(ResponseEntity.notFound().build(), response);
        verify(nbService, times(1)).save(1L, userNB);
    }
}