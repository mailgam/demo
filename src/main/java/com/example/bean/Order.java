package com.example.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "ORDER_NUMBER")
    private Integer orderNumber;

    @Lob
    @Column(name = "ORDER_STATUT")
    private String orderStatut;

    @Lob
    @Column(name = "CLIENT_NAME")
    private String clientName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ARTICLES_ID")
    private Article articles;

}