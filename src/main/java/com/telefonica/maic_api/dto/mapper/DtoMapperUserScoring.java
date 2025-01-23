package com.telefonica.maic_api.dto.mapper;

import com.telefonica.maic_api.dto.UserScoringDto;
import com.telefonica.maic_api.entity.UserScoring;

public class DtoMapperUserScoring {

    private UserScoring scoring;

    private DtoMapperUserScoring() {
    }

    public static DtoMapperUserScoring builder() {
        return new DtoMapperUserScoring();
    }

    public DtoMapperUserScoring setUserScoring(UserScoring scoring) {
        this.scoring = scoring;
        return this;
    }

    public UserScoringDto build() {
        if (scoring == null) {
            throw new RuntimeException("You should send an entity!");
        }
        return new UserScoringDto(this.scoring.getNumTelefono(), this.scoring.getNombre(), this.scoring.getAdelantaPago(),
                this.scoring.getTramo0(), this.scoring.getTramo30(), this.scoring.getTramo60());
    }

}
