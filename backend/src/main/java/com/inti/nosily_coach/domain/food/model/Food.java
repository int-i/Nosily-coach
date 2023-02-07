package com.inti.nosily_coach.domain.food.model;

import com.inti.nosily_coach.domain.Eat.model.Eat;
import com.inti.nosily_coach.domain.common.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Food extends BaseEntity {
    @Column(length = 20, nullable = false)
    private String name;

    @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
    private List<Eat> eats = new ArrayList<>();

    @Column
    private Long kcal; // 칼로리

    @Column
    private Float protein; // 단백질

    @Column
    private Float Car; // Carbohydrates : 탄수화물

    @Column
    private Float fat; // 지방

    // 고객이 직접 음식 정보를 입력할 수 있어야함
    @Builder(access = AccessLevel.PRIVATE)
    private Food(String name, Long kcal, Float protein, Float Car, Float fat) {
        this.name = name;
        this.kcal = kcal;
        this.protein = protein;
        this.Car = Car;
        this.fat = fat;
    }

    public static Food newFood(String name, Long kcal, Float protein, Float Car, Float fat) {
        return Food.builder()
                .name(name)
                .kcal(kcal)
                .protein(protein)
                .Car(Car)
                .fat(fat)
                .build();
    }
}
