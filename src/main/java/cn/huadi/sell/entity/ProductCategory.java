package cn.huadi.sell.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ProjectName:  sell 
 * @Package:      cn.huadi.sell.entity.ProducterCategory.java 
 * @Description:  类目表实体类 
 * @Author:       caipeng
 * @CreateDate:   2020/2/17 18:39 
 * @Version:      v1.0
 *  
 */
@NoArgsConstructor
@Data
@TableName(value = "product_category")
public class ProductCategory extends BaseEntity {

    /**
     * 类目id
     */
    @TableId(value = "category_id", type = IdType.AUTO)
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(update = "now()")
    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}







