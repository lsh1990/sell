package com.lsh.service;

import com.lsh.dto.OrderDTO;

/**
    * @Description: 推送消息
	* @Param
	* @Return
    * @author lsh
    * @date 2018/11/24 17:05
    */
public interface PushMessageService {
    /**
        * @Description: 订单状态变更消息
    	* @Param [orderDTO]
    	* @Return void
        * @author lsh
        * @date 2018/11/24 17:06
        */
    void orderStatus(OrderDTO orderDTO);
}
