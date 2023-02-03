package com.inti.nosily_coach.domain.food.repository;


import com.inti.nosily_coach.domain.food.model.Food;
import java.util.*;

public class FoodRepositoryCustomImpl implements FoodRepositoryCustom {

    private static Map<Long, Food> store = new HashMap<>(); // 음식 임시저장소

    @Override
    public Food save(Food food) {
        store.put(food.getId(), Food.newFood(food.getName(), food.getKcal(), food.getProtein(), food.getCar(), food.getFat()));
        return food;
    }

    @Override
    public Optional<Food> findByName(String name) {
        return store.values().stream() // store에 저장된 Food 객체로 새로운 리스트를 만들어서 stream 객체로 바꿈.
                .filter(food -> food.getName().equals(name)) // food 스트림의 첫번재 요소부터 마지막 요소까지 반복하면서 매개변수 name과 비교해 같으면 true를 반환하여 또다른 새로운 스트림 객체를 만들고 false면 버림.
                .findAny(); // 그렇게 만들어진 새로운 스트림 객체에서 가장 첫번째 Food 객체를 Optional<Food>에 넣어서 반환하고, 빈 스트림 객체라면 null 값을 Optional<Food>에 넣어서 반환함.
            }

    @Override
    public List<Food> findAll() {
        return new ArrayList<>(store.values()); // store에 있는 Food 객체들로 새로운 ArrayList를 만들어 반환함.
    }
}