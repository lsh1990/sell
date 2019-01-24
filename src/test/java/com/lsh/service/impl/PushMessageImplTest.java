package com.lsh.service.impl;

import com.lsh.dto.OrderDTO;
import com.lsh.service.OrderService;
import com.lsh.service.PushMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PushMessageImplTest {

    @Autowired
    private PushMessageService pushMessageService;
    @Autowired
    private OrderService orderService;
    @Test
    public void orderStatus() {
        OrderDTO one = orderService.findOne("");
    }
}