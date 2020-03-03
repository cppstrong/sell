package cn.huadi.sell.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ProjectName:  sell 
 * @Package:      cn.huadi.sell.entity.null.java 
 * @Description:  商品 
 * @Author:       caipeng
 * @CreateDate:   2020/2/17 21:44 
 * @Version:      v1.0
 *  
 */

@Data
@TableName(value = "product_info")
public class ProductInfo extends BaseEntity{

    @TableId
    private String productId;

    /** 名称. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 商品状态,0正常 1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    /** 创建时间*/
    private Date createTime;

    /** 更新时间*/
    @TableField(update = "now()")
    private Date updateTime;

}
