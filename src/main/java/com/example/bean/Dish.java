package com.example.bean;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "DISH")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DISH_ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "DISH_NAME")
    private String dishName;

    @ManyToMany(mappedBy = "dishes")
    private List<Order> orders;

}