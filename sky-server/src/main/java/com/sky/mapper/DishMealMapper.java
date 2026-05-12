package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishMealMapper {

    List<Long> getMealByDishIds(List<Long> ids);
}
