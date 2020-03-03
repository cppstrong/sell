package cn.huadi.sell.service.impl;

import cn.huadi.sell.entity.ProductCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName CategoryServiceImplTest.java
 * @Description TODO
 * @createTime 2020年02月22日 01:07:00
 */
@SpringBootTest
class CategoryServiceImplTest {

    @Autowired
    private CategoryServiceImpl categoryservice;

    @Test
    void selectOne() {
        ProductCategory category = categoryservice.SelectOne(1);
        Assertions.assertEquals(Integer.parseInt("1"),category.getCategoryType());
    }

    @Test
    void selectAll() {
        List<ProductCategory> categoryList = categoryservice.selectAll();
        Assertions.assertNotEquals(0,categoryList.size());

    }

    @Test
    void selectListByTypeIn() {
        List<Integer> typeList = Arrays.asList(2,3);
        List<ProductCategory> categoryList = categoryservice.selectListByTypeIn(typeList);
        Assertions.assertNotEquals(0,categoryList.size());
    }

    @Transactional
    @Test
    void insert() {
        ProductCategory category = new ProductCategory("儿童最f",4);
        Boolean flag = categoryservice.insert(category);
        Assertions.assertTrue(flag);
    }

    @Transactional
    @Test
    void update() {
        ProductCategory category = new ProductCategory("儿童最爱",4);
        Boolean flag = categoryservice.update(category);
        Assertions.assertTrue(flag);
    }
}