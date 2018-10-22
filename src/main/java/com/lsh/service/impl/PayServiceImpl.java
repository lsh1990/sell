package com.lsh.service.impl;

import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import com.lsh.dto.OrderDTO;
import com.lsh.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @ClassName PayServiceImpl
 * @Description: TODO
 * @Author lsh
 * @Date 2018/10/21 20:26
 * @Version
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {
    /**
     * 发起支付
     *
     * @param orderDTO
     */
    @Override
    public void create(OrderDTO orderDTO) {

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();

    }
}
