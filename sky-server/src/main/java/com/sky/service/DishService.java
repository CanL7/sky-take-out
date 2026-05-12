package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishService {
        /**
        * 保存菜品基本信息到菜品表
        * 保存菜品口味信息到菜品口味表
        * @param dishDTO
        */
        void save(DishDTO dishDTO);
}
