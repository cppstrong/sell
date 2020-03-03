package cn.huadi.sell.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 蔡鹏
 * @version 1.0.0
 * @ClassName ProductVO.java
 * @Description 商品（包含类目）
 * @createTime 2020年02月22日 19:18:00
 */
@Data
public class ProductCategoryVO {

    @JsonProperty("name")
    private String CategoryName;

    @JsonProperty("type")
    private Integer CategoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;
}
