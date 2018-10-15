package com.lsh.dto;

import lombok.Data;

/**
 * @ClassName CarDTO
 * @Description: 购物车加减库存
 * @Author lsh
 * @Date 2018/10/13 21:17
 * @Version
 */
@Data
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
