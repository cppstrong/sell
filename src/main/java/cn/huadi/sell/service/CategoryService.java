package cn.huadi.sell.service;

import cn.huadi.sell.entity.ProductCategory;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ICategoryService.java
 * @Description TODO
 * @createTime 2020年02月21日 23:16:00
 */
public interface CategoryService {

    ProductCategory SelectOne(Integer categoryId);

    List<ProductCategory> selectAll();

    List<ProductCategory> selectListByTypeIn(List<Integer> categoryTypeList);

    Boolean insert(ProductCategory category);

    Boolean update(ProductCategory category);

}
