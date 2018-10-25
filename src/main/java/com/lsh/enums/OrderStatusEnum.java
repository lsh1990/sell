package com.lsh.enums;

import lombok.Getter;

/**
 * @ClassName OrderStatusEnum
 * @Description: 订单状态
 * @Author lsh
 * @Date 2018/10/11 20:57
 * @Version
 */
@Getter
public enum OrderStatusEnum implements CodeEnum{
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "已取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
