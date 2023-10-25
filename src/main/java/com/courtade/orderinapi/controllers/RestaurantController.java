package com.courtade.orderinapi.controllers;

import com.courtade.orderinapi.dtos.RestaurantDTO;
import com.courtade.orderinapi.entities.Restaurant;
import com.courtade.orderinapi.entities.User;
import com.courtade.orderinapi.services.RestaurantService;
import com.courtade.orderinapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class RestaurantController {

    private RestaurantService restaurantService;
    private UserService userService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService, UserService userService) {
        this.restaurantService = restaurantService;
        this.userService = userService;
    }

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping("/restaurants/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable int id) {
        Restaurant restaurant = restaurantService.findById(id);
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if (restaurant == null) {
            restaurantDTO.setHttpStatus(HttpStatus.NOT_FOUND);
            restaurantDTO.setRestaurant(null);
            return restaurantDTO;
        }
        restaurantDTO.setHttpStatus(HttpStatus.OK);
        restaurantDTO.setRestaurant(restaurant);

        return restaurantDTO;
    }

    @PostMapping("/restaurants")
    public RestaurantDTO createRestaurant(@RequestBody Restaurant restaurant) {
        User user = userService.findById(restaurant.getOwnerId());
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        if (user == null) {
            restaurantDTO.setHttpStatus(HttpStatus.BAD_REQUEST);
            restaurantDTO.setRestaurant(null);
            return restaurantDTO;
        }
        restaurantDTO.setHttpStatus(HttpStatus.OK);
        restaurantDTO.setRestaurant(restaurantService.save(restaurant));

        return restaurantDTO;
    }

    @PutMapping("/restaurants")
    public Restaurant updateRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.save(restaurant);
    }

    @DeleteMapping("/restaurants/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        Restaurant restaurant = restaurantService.findById(id);
        if (restaurant == null) {
            throw new RuntimeException("Restaurant id not found " + id);
        }
        restaurantService.deleteById(id);
    }
}
