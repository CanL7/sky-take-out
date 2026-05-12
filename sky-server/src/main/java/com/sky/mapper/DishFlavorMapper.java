package com.sky.mapper;

import com.sky.entity.DishFlavor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DishFlavorMapper {

    void saveFlavors(List<DishFlavor> dishFlavors);

    /**
     * 批量删除菜品口味
     * @param ids
     */
    void deleteBatch(List<Long> ids);
}
