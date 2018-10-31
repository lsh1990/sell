package com.lsh.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lsh.dataobject.OrderDetail;
import com.lsh.enums.OrderStatusEnum;
import com.lsh.enums.PayStatusEnum;
import com.lsh.utils.serializer.Date2Long;
import com.lsh.utils.serializer.EnumUtil;
import lombok.Data;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName OrderDTO
 * @Description: 订单-DTO
 * @Author lsh
 * @Date 2018/10/13 14:21
 * @Version
 * 注解：属性为NULL的字段，不返回给前端
 * @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
 * @JsonInclude(JsonInclude.Include.NON_NULL)
 */
@Data
public class OrderDTO {

    /** 订单id. */
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家手机号. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信Openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认为0新下单. */
    private Integer orderStatus;

    /** 支付状态, 默认为0未支付. */
    private Integer payStatus;

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    @JsonSerialize(using = Date2Long.class)
    private Date updateTime;

    /** 订单详情. */
    List<OrderDetail> orderDetailList = new ArrayList<>();

    /** 获取订单状态信息.*/
    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum() {
        return  EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    /** 获取支付状态信息.*/
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum() {
        return  EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
