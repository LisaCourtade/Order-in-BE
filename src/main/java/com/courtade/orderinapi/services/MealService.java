package com.courtade.orderinapi.services;

import com.courtade.orderinapi.entities.Meal;
import com.courtade.orderinapi.entities.Restaurant;
import com.courtade.orderinapi.repositories.MealRepository;
import com.courtade.orderinapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    private MealRepository mealRepository;
    private RestaurantRepository restaurantRepository;
    @Autowired
    public MealService(MealRepository mealRepository, RestaurantRepository restaurantRepository) {
        this.mealRepository = mealRepository;
        this.restaurantRepository = restaurantRepository;
    }

    public List<Meal> findAll() {
        return mealRepository.findAll();
    };

    public List<Meal> findByRestaurantId(Integer id) {
        Optional<Restaurant> result = restaurantRepository.findById(id);
        Restaurant restau = null;
        if (result.isPresent()) {
            restau = result.get();
        } else {
            throw new RuntimeException("Did not find restaurant with id " + id);
        }
        return mealRepository.findByRestaurant(restau);
    }

    public Meal findById(Integer id) {
        Optional<Meal> result = mealRepository.findById(id);
        Meal meal = null;
        if (result.isPresent()) {
            meal = result.get();
        } else {
            throw new RuntimeException("Did not find meal with id " + id);
        }
        return meal;
    };

    public Meal save(Meal meal) {
        return mealRepository.save(meal);
    }

    public void deleteById(Integer id) {
        mealRepository.deleteById(id);
    }
}
