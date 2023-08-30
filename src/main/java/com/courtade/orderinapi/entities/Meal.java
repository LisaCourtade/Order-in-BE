package com.courtade.orderinapi.entities;

import jakarta.persistence.*;

@Entity
@Table(name="meal")
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private double price;

    @Column(name="ingredients")
    private String ingredients;

    @Column(name="category")
    private String category;

    @ManyToOne
    @JoinColumn(name="restaurant_id", referencedColumnName = "id")
    private Restaurant restaurant;

    public Meal() {
    }

    public Meal(String name, double price, String ingredients, String category, Restaurant restaurant) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.category = category;
        this.restaurant = restaurant;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
