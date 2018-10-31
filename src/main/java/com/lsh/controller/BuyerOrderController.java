package com.lsh.controller;

import com.lsh.VO.ResultVO;
import com.lsh.converter.OrderForm2OrderDTO;
import com.lsh.dto.OrderDTO;
import com.lsh.enums.ResultEnum;
import com.lsh.exception.SellException;
import com.lsh.form.OrderForm;
import com.lsh.service.BuyerService;
import com.lsh.service.OrderService;
import com.lsh.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName BuyerOrderController
 * @Description: TODO
 * @Author lsh
 * @Date 2018/10/14 20:11
 * @Version
 */
@RestController
@Slf4j
@RequestMapping("/buyer/order")
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    /**
        * @Description: 创建订单
    	* @Param [orderForm, bindingResult]
    	* @Return com.lsh.VO.ResultVo<java.util.Map<java.lang.String,java.lang.String>>
        * @author lsh
        * @date 2018/10/14 21:03
        */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确, orderForm={}", orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTO.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO creatResult = orderService.create(orderDTO);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("orderId", creatResult.getOrderId());
        return ResultVoUtil.success(map);
    }
    /**
        * @Description: 获取订单列表
    	* @Param [openid, page, size]
    	* @Return com.lsh.VO.ResultVo<java.util.List<com.lsh.dto.OrderDTO>>
        * @author lsh
        * @date 2018/10/14 21:44
        */
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid,
                                         @RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);

        return ResultVoUtil.success(orderDTOPage.getContent());
    }
    /**
        * @Description: 订单详情
    	* @Param [openid, orderId]
    	* @Return com.lsh.VO.ResultVo<com.lsh.dto.OrderDTO>
        * @author lsh
        * @date 2018/10/15 21:57
        */
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderId") String orderId) {
        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderDTO);
    }
    /**
        * @Description: 取消订单
    	* @Param [openid, orderId]
    	* @Return com.lsh.VO.ResultVo
        * @author lsh
        * @date 2018/10/16 20:17
        */
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid") String openid,
                           @RequestParam("orderId") String orderId) {
        buyerService.cancelOrder(openid, orderId);
        return ResultVoUtil.success();
    }
}
