package com.example.dto;

import com.example.bean.Article;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;

public class OrderDto extends AbstractDto<Integer> {
    @Max(Integer.MAX_VALUE)
    private Integer id;
    @Max(Integer.MAX_VALUE)
    private Integer orderNumber;
    @Size(max = 255)
    private String orderStatut;
    @Size(max = 255)
    private String clientName;
    private Article articles;

    public OrderDto() {
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderNumber() {
        return this.orderNumber;
    }

    public void setOrderStatut(String orderStatut) {
        this.orderStatut = orderStatut;
    }

    public String getOrderStatut() {
        return this.orderStatut;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientName() {
        return this.clientName;
    }

    public void setArticles(Article articles) {
        this.articles = articles;
    }

    public Article getArticles() {
        return this.articles;
    }
}