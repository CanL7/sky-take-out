package com.sky.service;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.vo.DishVO;

import java.util.List;

public interface DishService {
    /**
    * 保存菜品基本信息到菜品表
    * 保存菜品口味信息到菜品口味表
    * @param dishDTO
    */
    void saveWithFlavor(DishDTO dishDTO);


    /**
     * 分页查询菜品
     * @param dishPageQueryDTO
     * @return
     */
    PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);

    /**
     * 批量删除菜品
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     * 根据id查询菜品信息
     * @param id
     * @return
     */
    DishVO getDishWithFlavor(Long id);

    /**
     * 更新菜品信息
     * @param dishDTO
     */
    void updateWithFlavor(DishDTO dishDTO);
}
