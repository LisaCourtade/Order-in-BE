package com.courtade.orderinapi.meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MealController {

    private MealService mealService;
    @Autowired
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @GetMapping("/meals")
    public List<Meal> getMeals() {
        return mealService.findAll();
    }

    @GetMapping("/meals/restaurant/{id}")
    public List<Meal> getMealsByRestaurant(@PathVariable int id) {
        return mealService.findByRestaurantId(id);
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
