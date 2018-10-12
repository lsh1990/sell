package com.lsh.enums;

import lombok.Getter;

/**
 * @ClassName PayStatusEnum
 * @Description: 支付状态
 * @Author lsh
 * @Date 2018/10/11 21:07
 * @Version
 */
@Getter
public enum PayStatusEnum {
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;


    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
