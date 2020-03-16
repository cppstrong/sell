package cn.huadi.sell.dao;

import cn.huadi.sell.entity.ProductCategory;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @ProjectName:  sell 
 * @Package:      cn.huadi.sell.dao.JUnit5 Test Class.java.java 
 * @Description:  一句话描述该类的功能 
 * @Author:       caipeng
 * @CreateDate:   2020/2/17 22:02 
 * @Version:      v1.0
 *  
 */

@SpringBootTest
@Slf4j
public class ProductCategoryDAOTest {

    @Autowired
    private ProductCategoryDAO PCMapper;

    @Test
    public void fondOneTest() {
        ProductCategory productCategory = PCMapper.selectById(2);

        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional
    public void insertTest() {
        ProductCategory category = new ProductCategory("男生最爱", 3);
        Integer result = PCMapper.insert(category);
        Assertions.assertNotNull(result, "测试assertNotNull");
//        Assertions.assertNotEquals(null,result,"测试assert equals");
    }

    @Test
    public void updateTest() {
        ProductCategory category = PCMapper.selectById(1);
        category.setCategoryName("男生最爱");
        PCMapper.updateById(category);
    }

    @Test
    public void selectListByIds() {
        List<Integer> idList = Arrays.asList(2, 3, 4);
        List<ProductCategory> result = PCMapper.selectBatchIds(idList);
        Assertions.assertNotEquals(0, result.size());
    }

    @Test
    public void selectListByTypeIn() {
        QueryWrapper<ProductCategory> wrapper = new QueryWrapper<ProductCategory>();
        wrapper.in("category_type", Arrays.asList(2, 3));
        List<ProductCategory> categoryList = PCMapper.selectList(wrapper);
        System.out.println(categoryList.toString());
    }

    @Test
    public void selectAll() {
        List<ProductCategory> categoryList = PCMapper.selectList(null);
        Assertions.assertNotNull(categoryList);
    }

}