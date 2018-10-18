package com.lsh.service.impl;

import com.lsh.dto.OrderDTO;
import com.lsh.enums.ResultEnum;
import com.lsh.exception.SellException;
import com.lsh.service.BuyerService;
import com.lsh.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BuyerServiceImpl
 * @Description: 用于处理特殊业务，人员校验
 * @Author lsh
 * @Date 2018/10/16 20:26
 * @Version
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;
    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】查不到改订单, orderId={}", orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    /**
     * 校验订单所属人
     * @param openid
     * @param orderId
     * @return
     */
    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        //判断是否是自己的订单
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)) {
            log.error("【查询订单】订单的openid不一致. openid={}, orderDTO={}", openid, orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}
