package com.example.dto;

import com.example.bean.Order;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

import java.util.List;

public class DishDto extends AbstractDto<Integer> {
    @Max(Integer.MAX_VALUE)
    private Integer id;
    @Size(max = 255)
    private String dishName;
    private List<Order> orders;

    public DishDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDishName() {
        return this.dishName;
    }

    public void setOrders(java.util.List<com.example.bean.Order> orders) {
        this.orders = orders;
    }

    public java.util.List<com.example.bean.Order> getOrders() {
        return this.orders;
    }
}