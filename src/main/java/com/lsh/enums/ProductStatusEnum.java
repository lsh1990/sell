package com.lsh.enums;

import lombok.Getter;

/**
 * @ClassName ProductStatusEnum
 * @Description: 商品状态
 * @Author lsh
 * @Date 2018/10/7 15:39
 * @Version
 */
@Getter
public enum ProductStatusEnum {
    /**
     * 在架
     */
    UP(0,"在架"),
    /**
     * 下架
     */
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
