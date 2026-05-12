package com.sky.controller.admin;

import com.alibaba.druid.sql.PagerUtils;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Slf4j
public class DishController {

    @Autowired
    private DishService dishService;

    @PostMapping
    public Result saveWithFlavor(@RequestBody DishDTO dishDTO) {
        //保存菜品基本信息到菜品表
        dishService.saveWithFlavor(dishDTO);
        //保存菜品口味信息到菜品口味表
        return Result.success();
    }


    @GetMapping("/page")
    //Query查询 不用注解
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO) {
        log.info("启动分页查询");
        PageResult pageResult = dishService.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Long> ids) {
        log.info("根据ids批量删除菜品，ids：{}", ids);
        dishService.deleteBatch(ids);
        return Result.success();
    }


    @GetMapping("/{id}")
    public Result<DishVO> getDishWithFlavor(@PathVariable Long id) {
        log.info("根据id查询菜品信息，id：{}", id);
        DishVO dishVO = dishService.getDishWithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping
    public Result updateWithFlavor(@RequestBody DishDTO dishDTO) {
        log.info("更新菜品信息，dishDTO：{}", dishDTO);
        dishService.updateWithFlavor(dishDTO);
        return Result.success();
    }

    /**
     * 根据分类id查询菜品
     * @param categoryId
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据分类id查询菜品")
    public Result<List<Dish>> list(Long categoryId){
        List<Dish> list = dishService.list(categoryId);
        return Result.success(list);
    }

}