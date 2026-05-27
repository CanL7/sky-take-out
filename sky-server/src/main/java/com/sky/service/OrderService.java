package com.sky.service;

import com.sky.dto.OrdersSubmitDTO;
import com.sky.vo.OrderSubmitVO;

public interface OrderService {

    /**
     * 订单提交
     * @param ordersSubmitDTO
     * @return
     */
    public OrderSubmitVO orderSubmit(OrdersSubmitDTO ordersSubmitDTO);
}