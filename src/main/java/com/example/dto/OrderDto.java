package com.example.dto;

import com.example.annotation.CheckDate;
import com.example.annotation.CheckEmail;
import com.example.bean.Dish;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class OrderDto extends AbstractDto<Integer> {
    @Max(Integer.MAX_VALUE)
    private Integer id;
    @Max(Integer.MAX_VALUE)
    private Integer orderNumber;
    @Size(max = 255)
    private String orderStatut;
    @Size(max = 255)
    private String clientName;
    @CheckEmail(message = "Email is not valid")
    private String clientEmail;

    @CheckDate(message = "Date is not valid")
    private Date clientBirthDate;
    private List<Dish> dishes;

}