package com.sky.controller.admin;

import com.alibaba.druid.sql.PagerUtils;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public Result saveWithFlavor(@RequestBody DishDTO dishDTO) {
        //保存菜品基本信息到菜品表
        dishService.save(dishDTO);
        //保存菜品口味信息到菜品口味表
        return Result.success();
    }


    @GetMapping("/page")
    //Query查询 不用注解
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids) {
        dishService.deleteBatch(ids);
        return Result.success();
    }
}
