package com.example.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ORDER_ID", nullable = false)
    private Integer id;

    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber;

    @Column(name = "ORDER_STATUT")
    private String orderStatut;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_EMAIL")
    private String clientEmail;

    @Column(name = "CLIENT_BIRTHDATE")
    private Date clientBirthDate;


    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(
            name = "order_dish",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "dish_id"
            )
    )
    private List<Dish> dishes;

}