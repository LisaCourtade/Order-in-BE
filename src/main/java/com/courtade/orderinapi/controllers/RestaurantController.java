package com.courtade.orderinapi.controllers;

import com.courtade.orderinapi.entities.Restaurant;
import com.courtade.orderinapi.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurantById(@PathVariable int id) {
        Restaurant restaurant = restaurantService.findById(id);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant id not found " + id);
        }
        return restaurant;
    }

    @PostMapping("/restaurants")
    public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @PutMapping("/restaurants")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        Restaurant restaurant = restaurantService.findById(id);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant id not found " + id);
        }
        restaurantService.deleteById(id);
    }
}
