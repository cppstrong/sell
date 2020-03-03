package cn.huadi.sell.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderDetail.java
 * @Description 订单详情
 * @createTime 2020年02月23日 12:25:00
 */
@Data
public class OrderDetail {

    /** 订单详情id. */
    @TableId
    private String detailId;

    /** 订单id. */
    private String orderId;

    /** 商品id. */
    private String productId;

    /** 商品名称. */
    private String productName;

    /** 当前价格,单位分. */
    private BigDecimal productPrice;

    /** 数量. */
    private Integer productQuantity;

    /** 小图. */
    private String productIcon;


}
