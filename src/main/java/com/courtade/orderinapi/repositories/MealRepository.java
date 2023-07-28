package com.courtade.orderinapi.repositories;

import com.courtade.orderinapi.entities.Meal;
import com.courtade.orderinapi.entities.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends JpaRepository<Meal, Integer> {

    List<Meal> findByRestaurant(Restaurant restaurant);
}
