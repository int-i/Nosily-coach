package com.inti.nosily_coach.domain.Eat.Service;

import com.inti.nosily_coach.domain.Eat.DTO.EatDTO;
import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.Eat.repository.EatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 의존성 자동 주입
public class EatServiceImpl implements EatService {
    private final EatRepository eat_repository;
    @Override
    public Long register(EatDTO eat_dto) { // 추가하는 메서드
        Eat eat_entity = dtoToEntity(eat_dto);

        eat_repository.save(eat_entity);

        return eat_entity.getId();
    }ㅊ
}
