package com.lsh.service;

import com.lly835.bestpay.model.PayResponse;
import com.lsh.dto.OrderDTO;

/**
    * @Description: 支付业务逻辑
	* @Param
	* @Return  
    * @author lsh
    * @date 2018/10/21 20:23
    */
public interface PayService {

    /**
     * 发起支付
     * @param orderDTO
     */
    PayResponse create(OrderDTO orderDTO);

    /**
     * 微信异步通知下单状态
     * @param notifyData
     * @return
     */
    PayResponse notify(String notifyData);
}
