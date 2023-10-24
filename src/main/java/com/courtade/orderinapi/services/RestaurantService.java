package com.courtade.orderinapi.services;

import com.courtade.orderinapi.entities.Restaurant;
import com.courtade.orderinapi.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    };

    public Restaurant findById(int id) {
        Optional<Restaurant> result = restaurantRepository.findById(id);
        Restaurant restaurant = null;
        if (result.isPresent()) {
            restaurant = result.get();
        } else {
            throw new RuntimeException("Did not find restaurant with id " + id);
        }
        return restaurant;
    }

    public Restaurant save(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    public void deleteById(int id) {
        restaurantRepository.deleteById(id);
    }
}
