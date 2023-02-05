package com.inti.nosily_coach.domain.Eat.Service;

import com.inti.nosily_coach.domain.Eat.DTO.EatDTO;
import com.inti.nosily_coach.domain.Eat.model.Eat;

public interface EatService {
    Long register(EatDTO eat_dto);

    default Eat dtoToEntity(EatDTO eat_dto) { // 서비스 계층에서 파라미터를 DTO 타입으로 받기 때문에 JPA로 처리하기 위해 엔티티 타입의 객체로 변환
        Eat eat_entity = Eat.builder()
                .dietRecord(eat_dto.getDietRecord())
                .food(eat_dto.getFood())
                .intake(eat_dto.getIntake())
                .build();
        return eat_entity;
    }

    default EatDTO entityToDto(Eat eat_entity) {
        EatDTO eat_dto = EatDTO.builder()
                .id(eat_entity.getId())
                .dietRecord(eat_entity.getDietRecord())
                .food(eat_entity.getFood())
                .intake(eat_entity.getIntake())
                .build();
        return eat_dto;
    }


}
