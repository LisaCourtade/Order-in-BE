package com.courtade.orderinapi.dtos;

import com.courtade.orderinapi.entities.Meal;
import org.springframework.http.HttpStatus;

import java.util.List;

public class MealsDTO {

    HttpStatus httpStatus;

    List<Meal> meals;

    public MealsDTO() {
    }

    public MealsDTO(HttpStatus httpStatus, List<Meal> meals) {
        this.httpStatus = httpStatus;
        this.meals = meals;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
