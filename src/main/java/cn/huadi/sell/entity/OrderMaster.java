package cn.huadi.sell.entity;

import cn.huadi.sell.enums.OrderStatusEnum;
import cn.huadi.sell.enums.PayStatusEnum;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderMaster.java
 * @Description 订单主表
 * @createTime 2020年02月23日 11:56:00
 */
@Data
public class OrderMaster extends BaseEntity{

    /** 订单id. */
    @TableId
    private String orderId;

    /** 买家名字. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信openid. */
    private String buyerOpenid;

    /** 订单总金额. */
    private BigDecimal orderAmount;

    /** 订单状态, 默认0为新下单. */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态, 默认0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间. */
    private Date createTime;

    /** 更新时间. */
    @TableField(update = "now()")
    private Date updateTime;

}
