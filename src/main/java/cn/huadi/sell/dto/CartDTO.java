package cn.huadi.sell.dto;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CartDTO.java
 * @Description 购物车
 * @createTime 2020年02月24日 11:24:00
 */
@Data
public class CartDTO {

    /**
     * 商品id.
     */
    private String productId;

    /**
     * 商品数量.
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
