package com.lsh.service;

import com.lsh.dto.OrderDTO;

/**
    * @Description: 用于处理特殊业务，人员校验
	* @Param
	* @Return
    * @author lsh
    * @date 2018/10/16 20:21
    */
public interface BuyerService {
    /**
     * 查询一个订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO findOrderOne(String openid, String orderId);

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    OrderDTO cancelOrder(String openid, String orderId);
}
