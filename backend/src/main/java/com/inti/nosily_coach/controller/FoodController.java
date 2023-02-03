package com.inti.nosily_coach.controller;

import com.inti.nosily_coach.Service.FoodService;
import com.inti.nosily_coach.domain.food.model.Food;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("api") // 백엔드 URL(api 방식으로 통신하고 있기 때문에)
public class FoodController {
    @RequestMapping(value = "/food", method = RequestMethod.GET)
    @ResponseBody
    public Food createFoodApi(@RequestParam("name") String name, // 음식 생성하는 메서드
                              @RequestParam("kcal") Long kcal,
                              @RequestParam("protein") Float protein,
                              @RequestParam("car") Float car,
                              @RequestParam("fat") Float fat) { // 데이터를 반환하는 메서드

        Food food = Food.newFood(name, kcal, protein, car, fat);
        FoodService foodService = new FoodService();
        foodService.insertFood(food);
        return food;
    }

    @RequestMapping(value = "/viewfoods", method = RequestMethod.GET)
    @ResponseBody
    public List<Food> viewFoodsApi() { // 음식들 조회하는 메서드
        FoodService foodService = new FoodService();
        return foodService.findFoods();
    }

    @RequestMapping(value = "/viewfood", method = RequestMethod.GET)
    @ResponseBody
    public Food viewFoodApi(@RequestParam("food_name") String food_name) { // 음식 조회하는 메서드
        FoodService foodService = new FoodService();
        return foodService.findOne(food_name).get();
    }

}