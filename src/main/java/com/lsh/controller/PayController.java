package com.lsh.controller;

import com.lly835.bestpay.model.PayResponse;
import com.lsh.dto.OrderDTO;
import com.lsh.enums.ResultEnum;
import com.lsh.exception.SellException;
import com.lsh.service.OrderService;
import com.lsh.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

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
    @Autowired
    private PayService payService;

    /**
     * @Description: 创建支付订单
     * @Param [order, returnUrl]
     * @Return void
     * @author lsh
     * @date 2018/10/21 20:13
     */
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl,
                               Map<String, Object> map) {
        //1.查询订单
        OrderDTO orderDTO = orderService.findOne(orderId);
        if (orderDTO == null) {
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
//        PayResponse payResponse = payService.create(orderDTO);
        map.put("orderId", orderId);
        return new ModelAndView("pay/create", map);
    }

    /**
     * 微信异步通知
     * @param notifyData
     */
    @PostMapping("/notify")
    public ModelAndView notify(@RequestBody String notifyData) {
        payService.notify(notifyData);
        //返回处理结果给微信端
        return new ModelAndView("pay/success");
    }
}
