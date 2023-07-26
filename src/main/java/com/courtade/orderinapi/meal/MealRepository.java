package com.courtade.orderinapi.meal;

import com.courtade.orderinapi.restaurant.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findByRestaurant(Restaurant restaurant);
}
