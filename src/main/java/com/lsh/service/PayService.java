package com.lsh.service;

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
    void create(OrderDTO orderDTO);
}
