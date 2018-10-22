package com.lsh.controller;

import com.lsh.dto.OrderDTO;
import com.lsh.enums.ResultEnum;
import com.lsh.exception.SellException;
import com.lsh.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName PayController
 * @Description: 支付
 * @Author lsh
 * @Date 2018/10/21 20:09
 * @Version
 */
@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {

    @Autowired
    private OrderService orderService;

    /**
     * @Description: 创建支付订单
     * @Param [order, returnUrl]
     * @Return void
     * @author lsh
     * @date 2018/10/21 20:13
     */
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        
    }
}
