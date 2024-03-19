package com.example.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "ARTICLE")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "ARTICLE_NAME")
    private String articleName;

    @OneToMany(mappedBy = "articles")
    private Set<Order> orders = new LinkedHashSet<>();

}