package cn.huadi.sell.service;

import cn.huadi.sell.dto.CartDTO;
import cn.huadi.sell.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductService.java
 * @Description TODO
 * @createTime 2020年02月22日 14:15:00
 */
public interface ProductService {

    ProductInfo selectById(String productId);

    /**
     * @description 查询所以在架的商品列表
     * @author caipeng
     * @updateTime
     */
    List<ProductInfo> selectUpAll();

    Page<ProductInfo> selectAll(Page<ProductInfo> page);

    boolean insert(ProductInfo productInfo);

    boolean updateById(ProductInfo productInfo);

    //加库存
    void increaseStore(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStore(List<CartDTO> cartDTOList);
}
