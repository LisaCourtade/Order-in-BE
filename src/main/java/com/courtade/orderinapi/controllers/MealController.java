package com.courtade.orderinapi.controllers;

import com.courtade.orderinapi.dtos.MealsDTO;
import com.courtade.orderinapi.entities.Meal;
import com.courtade.orderinapi.entities.Restaurant;
import com.courtade.orderinapi.services.MealService;
import com.courtade.orderinapi.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class MealController {

    private MealService mealService;
    private RestaurantService restaurantService;

    @Autowired
    public MealController(MealService mealService, RestaurantService restaurantService) {
        this.mealService = mealService;
        this.restaurantService = restaurantService;
    }

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        return mealService.findAll();
    }

    @GetMapping("/meals/restaurant/{id}")
    public MealsDTO getMealsByRestaurant(@PathVariable int id) {
        Restaurant restaurant = restaurantService.findById(id);
        MealsDTO mealsDTO = new MealsDTO();
        if (restaurant == null) {
            mealsDTO.setHttpStatus(HttpStatus.NOT_FOUND);
            mealsDTO.setMeals(null);
            return mealsDTO;
        }
        mealsDTO.setHttpStatus(HttpStatus.OK);
        mealsDTO.setMeals(mealService.findByRestaurantId(id));
        return mealsDTO;
    }

    @GetMapping("/meals/{id}")
    public Meal getMealById(@PathVariable int id) {
        Meal meal = mealService.findById(id);
        if (meal == null) {
            throw new RuntimeException("Did not find meal id " + id);
        }
        return meal;
    }

    @PostMapping("/meals")
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    @PutMapping("/meals")
    public Meal updateMeal(@RequestBody Meal meal) {
        return mealService.save(meal);
    }

    @DeleteMapping("/meals/{id}")
    public void deleteMeal(@PathVariable int id) {
        Meal meal = mealService.findById(id);
        if (meal == null) {
            throw new RuntimeException("Did not find meal id " + id);
        }
        mealService.deleteById(id);
    }
}
