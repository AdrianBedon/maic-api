package com.telefonica.maic_api.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.telefonica.maic_api.dto.UserScoringDto;
import com.telefonica.maic_api.dto.mapper.DtoMapperUserScoring;
import com.telefonica.maic_api.entity.UserScoring;
import com.telefonica.maic_api.repository.UserScoringRepository;
import com.telefonica.maic_api.service.impl.UserScoringServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserScoringServiceImplTest {

    @Mock
    private UserScoringRepository userScoringRepository;

    @InjectMocks
    private UserScoringServiceImpl userScoringServiceImpl;

    private UserScoring userScoring;
    private UserScoringDto userScoringDto;

    @BeforeEach
    public void setUp() {
        userScoring = new UserScoring();
        userScoring.setNumTelefono("123456789");

        userScoringDto = DtoMapperUserScoring.builder().setUserScoring(userScoring).build();
    }

    @Test
    public void testFindByNumTelefono() {
        when(userScoringRepository.findByNumTelefono("123456789")).thenReturn(Optional.of(userScoring));

        Optional<UserScoring> result = userScoringServiceImpl.findByNumTelefono("123456789");

        assertTrue(result.isPresent());
        assertEquals(userScoring, result.get());
    }
}