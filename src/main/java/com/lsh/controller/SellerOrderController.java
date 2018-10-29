package com.lsh.controller;

import com.lsh.dto.OrderDTO;
import com.lsh.enums.ResultEnum;
import com.lsh.exception.SellException;
import com.lsh.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @ClassName SellerOrderController
 * @Description: 卖家端业务
 * @Author lsh
 * @Date 2018/10/23 21:46
 * @Version
 */
@Controller
@Slf4j
@RequestMapping("/seller/order")
public class SellerOrderController {

    @Autowired
    private OrderService orderService;

    /**
        * @Description: 查询订单列表
    	* @Param [page, size, map]
    	* @Return org.springframework.web.servlet.ModelAndView
        * @author lsh
        * @date 2018/10/27 20:31
        */
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "2") Integer size,
                             Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(pageRequest);
        map.put("orderDTOPage", orderDTOPage);
        map.put("currentPage", page);
        map.put("size", size);
        return new ModelAndView("/order/list", map);
    }


    /**
        * @Description: 取消订单
    	* @Param [orderId]
    	* @Return org.springframework.web.servlet.ModelAndView
        * @author lsh
        * @date 2018/10/27 20:36
        */
    @RequestMapping("/cancel")
    public ModelAndView cancel(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.cancel(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端取消订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_CANCEL_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

    /**
        * @Description: 查询订单详情
    	* @Param [orderId, map]
    	* @Return org.springframework.web.servlet.ModelAndView
        * @author lsh
        * @date 2018/10/27 21:20
        */
    @RequestMapping("/detail")
    public ModelAndView detail(@RequestParam("orderId") String orderId,
                               Map<String, Object> map) {
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        } catch (SellException e) {
            log.error("【卖家端查询订单详情】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }
        map.put("orderDTO", orderDTO);
        return new ModelAndView("order/detail", map);
    }

    /**
        * @Description: 完结订单
    	* @Param [orderId, map]
    	* @Return org.springframework.web.servlet.ModelAndView
        * @author lsh
        * @date 2018/10/27 22:24
        */
    @GetMapping("/finish")
    public ModelAndView finished(@RequestParam("orderId") String orderId,
                                 Map<String, Object> map) {
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderService.finish(orderDTO);
        } catch (SellException e) {
            log.error("【卖家端完结订单】发生异常{}", e);
            map.put("msg", e.getMessage());
            map.put("url", "/sell/seller/order/list");
            return new ModelAndView("common/error", map);
        }

        map.put("msg", ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url", "/sell/seller/order/list");
        return new ModelAndView("common/success");
    }

}
