package com.lsh.converter;

import com.lsh.dataobject.OrderMaster;
import com.lsh.dto.OrderDTO;
import org.hibernate.criterion.Order;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName OrderMaster2OrderDTO
 * @Description: order转换器
 * @Author lsh
 * @Date 2018/10/14 14:30
 * @Version
 */
public class OrderMaster2OrderDTO {

    public static OrderDTO convert(OrderMaster orderMaster) {
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasters) {
        List<OrderDTO> orderDTOList = orderMasters.stream().map(e -> convert(e)).collect(Collectors.toList());
        return orderDTOList;
    }
}
