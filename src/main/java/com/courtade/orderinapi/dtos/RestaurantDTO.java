package com.courtade.orderinapi.dtos;

import com.courtade.orderinapi.entities.Restaurant;
import org.springframework.http.HttpStatus;

public class RestaurantDTO {
    HttpStatus httpStatus;

    Restaurant restaurant;

    public RestaurantDTO() {
    }

    public RestaurantDTO(HttpStatus httpStatus, Restaurant restaurant) {
        this.httpStatus = httpStatus;
        this.restaurant = restaurant;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
