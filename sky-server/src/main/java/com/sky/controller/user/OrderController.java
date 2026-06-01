package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.OrderService;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("userOrderController")
@RequestMapping("/user/order")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 订单提交
     * @param ordersSubmitDTO
     * @return
     */
    @PostMapping("/submit")
    public Result<OrderSubmitVO> orderSubmit(OrdersSubmitDTO ordersSubmitDTO){
        log.info("订单提交:{}",ordersSubmitDTO);

        OrderSubmitVO orderSubmitVO = orderService.orderSubmit(ordersSubmitDTO);

        return Result.success(orderSubmitVO);
    }

    /**
     * @param pageNum
     * @param pageSize
     * @param status 订单状态 1待付款 2待接单 3已接单 4派送中 5已完成 6已取消
     * @return
     */
    @GetMapping("/historyOrders")
    public Result<PageResult> page(int pageNum,int pageSize,Integer status){
        PageResult pageResult = orderService.orderQuery4User(pageNum,pageSize,status);
        return Result.success(pageResult);
    }


    /**
     * 查询订单详情
     * @param id
     * @return
     */
    @GetMapping("/orderDetail/{id}")
    public Result<OrderVO> details(@PathVariable Long id){
        OrderVO orderVO = orderService.details(id);
        return Result.success(orderVO);
    }


    /**
     * 取消订单
     * @param id
     * @return
     */
    @PutMapping("/cancel/{id}")
    public Result cancel(@PathVariable Long id){
        orderService.cancel(id);
        return Result.success();
    }

    @PostMapping("/repetition/{id}")
    public Result repetition(@PathVariable Long id){
        orderService.repetition(id);
        return Result.success();
    }


}
