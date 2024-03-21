package com.example.mapper;

import com.example.bean.Dish;
import com.example.dto.DishDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DishMapper extends EntityMapper<DishDto, Dish> {
}