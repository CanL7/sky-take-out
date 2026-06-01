package com.sky.service;

import com.sky.dto.OrdersCancelDTO;
import com.sky.dto.OrdersConfirmDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.dto.OrdersRejectionDTO;
import com.sky.dto.OrdersSubmitDTO;
import com.sky.result.PageResult;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderSubmitVO;
import com.sky.vo.OrderVO;

public interface OrderService {

    /**
     * 订单提交
     * @param ordersSubmitDTO
     * @return
     */
    public OrderSubmitVO orderSubmit(OrdersSubmitDTO ordersSubmitDTO);

    /**
     * 查询历史订单（用户端）
     * @param pageNum
     * @param pageSize
     * @param status
     * @return
     */
    public PageResult orderQuery4User(int pageNum,int pageSize,Integer status);

    /**
     * 查询订单详情
     * @param id
     * @return
     */
    OrderVO details(Long id);

    /**
     * 用户取消订单
     * @param id
     */
    void cancel(Long id);

    /**
     * 再来一单
     * @param id
     */
    void repetition(Long id);

    /**
     * 条件搜索订单（商家端）
     * @param ordersPageQueryDTO
     * @return
     */
    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    /**
     * 各个状态的订单数量统计（商家端）
     * @return
     */
    OrderStatisticsVO statistics();

    /**
     * 接单（商家端）
     * @param ordersConfirmDTO
     */
    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    /**
     * 拒单（商家端）
     * @param ordersRejectionDTO
     */
    void rejection(OrdersRejectionDTO ordersRejectionDTO) throws Exception;

    /**
     * 商家取消订单
     * @param ordersCancelDTO
     */
    void cancel(OrdersCancelDTO ordersCancelDTO) throws Exception;

    /**
     * 派送订单（商家端）
     * @param id
     */
    void delivery(Long id);

    /**
     * 完成订单（商家端）
     * @param id
     */
    void complete(Long id);

}