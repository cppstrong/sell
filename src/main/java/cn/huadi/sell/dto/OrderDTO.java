package cn.huadi.sell.dto;

import cn.huadi.sell.entity.OrderDetail;
import cn.huadi.sell.enums.OrderStatusEnum;
import cn.huadi.sell.enums.PayStatusEnum;
import cn.huadi.sell.util.serializer.Date2LongSerializer;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderDTO.java
 * @Description DTO-数据传输对象， 将orderMaster和OrderDtail联系起来
 * @createTime 2020年02月23日 17:50:00
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL) 实现对象属性值为null的时候，不返回该字段给前端，或者配置文件配置全局的对象都是这个规则
public class OrderDTO {

    /**
     * 订单id.
     */
    private String orderId;

    /**
     * 买家名字.
     */
    private String buyerName;

    /**
     * 买家电话.
     */
    private String buyerPhone;

    /**
     * 买家地址.
     */
    private String buyerAddress;

    /**
     * 买家微信openid.
     */
    private String buyerOpenid;

    /**
     * 订单总金额.
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认0为新下单.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态, 默认0未支付.
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /**
     * 创建时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    /**
     * 更新时间.
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    @TableField(update = "now()")
    private Date updateTime;

    /**
     * 订单详情集合.
     */
    private List<OrderDetail> orderDetailList;
}
