package com.inti.nosily_coach.domain.SelectedExercise.service;

import com.inti.nosily_coach.domain.Exercise.model.Exercise;
import com.inti.nosily_coach.domain.Exercise.repository.ExerciseRepository;
import com.inti.nosily_coach.domain.ExerciseRecord.model.ExerciseRecord;
import com.inti.nosily_coach.domain.ExerciseRecord.repository.ExerciseRecordRepository;
import com.inti.nosily_coach.domain.SelectedExercise.model.SelectedExercise;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.CreateSelectedExerciseRequest;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.DeleteSelectedExerciseRequest;
import com.inti.nosily_coach.domain.SelectedExercise.model.dto.GetSelectedExerciseResponse;
import com.inti.nosily_coach.domain.SelectedExercise.repository.SelectedExerciseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SelectedExerciseServiceImpl implements SelectedExerciseService{
    private final SelectedExerciseRepository selectedExerciseRepository;
    private final ExerciseRepository exerciseRepository;
    private final ExerciseRecordRepository exerciseRecordRepository;

    // 매핑
    @Override
    @Transactional
    public void createSelectedExercise(Long memberId, Long exerciseId, LocalDate localDate, CreateSelectedExerciseRequest request) {
        Exercise exercise = exerciseRepository.findById(exerciseId).orElseThrow(()->new RuntimeException("해당되는 운동법이 없습니다."));
        ExerciseRecord exerciseRecord = exerciseRecordRepository.findByDate(memberId, localDate);
        selectedExerciseRepository.save(SelectedExercise.newSelectedExercise(exerciseRecord, exercise,
                request.getTimes(), request.getCounts(), request.getSetCnt()));
    }

    // 매핑 수정
    @Override
    @Transactional
    public void updateSelectedExercise(SelectedExercise selectedExercise, LocalTime times, int counts, int setCnt) {
        selectedExercise.update(times, counts, setCnt);
    }

    // 매핑 삭제
    @Override
    @Transactional
    public void deleteSelectedExercise(Long memberId, DeleteSelectedExerciseRequest request) {
        SelectedExercise selectedExercise = selectedExerciseRepository.findByRecordAndExercise(memberId, request.getExerciseId(), request.getRecordId());
        selectedExerciseRepository.delete(selectedExercise);
    }

    // DTO로 변환하여 출력
    @Override
    @Transactional
    public List<GetSelectedExerciseResponse> getSelectedExercise(List<SelectedExercise> selectedExercises) {
        return selectedExercises.stream().map(
                exercise -> GetSelectedExerciseResponse.of(exercise.getExercise().getId(), exercise.getExercise().getName(),
                        exercise.getCounts(), exercise.getSetCnt())).collect(Collectors.toList());
    }
}
