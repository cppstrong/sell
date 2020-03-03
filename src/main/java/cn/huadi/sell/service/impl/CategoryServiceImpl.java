package cn.huadi.sell.service.impl;

import cn.huadi.sell.dao.ProductCategoryDAO;
import cn.huadi.sell.entity.ProductCategory;
import cn.huadi.sell.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author caipeng
 * @version 1.0.0
 * @ClassName CategoryServiceImpl.java
 * @Description 类目
 * @createTime 2020年02月22日 00:11:00
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryDAO categoryMapper;

    @Override
    public ProductCategory SelectOne(Integer categoryId) {
        return categoryMapper.selectById(categoryId);
    }

    @Override
    public List<ProductCategory> selectAll() {
        return this.categoryMapper.selectList(null);
    }

    @Override
    public List<ProductCategory> selectListByTypeIn(List<Integer> categoryTypeList) {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<>();
        wrapper.in("category_type",categoryTypeList);
        return this.categoryMapper.selectList(wrapper);
    }

    @Override
    public Boolean insert(ProductCategory category) {
        int result = this.categoryMapper.insert(category);
        return 0 != result;
    }

    @Override
    public Boolean update(ProductCategory category) {
        int result = categoryMapper.updateById(category);
        return 0 != result;
    }
}
