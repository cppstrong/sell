package cn.huadi.sell.service.impl;

import cn.huadi.sell.entity.ProductInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductServiceImplTest.java
 * @Description TODO
 * @createTime 2020年02月22日 15:26:00
 */
@SpringBootTest
class ProductInfoServiceImplTest {

    @Autowired
    private ProductServiceImpl productService;

    @Test
    void selectById() {
        ProductInfo productInfo = productService.selectById("123456");
        Assertions.assertNotNull(productInfo);
    }

    @Test
    void selectUpAll() {
        List<ProductInfo> list = productService.selectUpAll();
        Assertions.assertNotEquals(0,list.size());
    }

    @Test
    void selectAll() {
        Page<ProductInfo> page = new Page<>(1,2);
        Page<ProductInfo> productPage = productService.selectAll(page);
        System.out.println(productPage.getCurrent());//当前第几页
        System.out.println(productPage.getRecords());//所有记录
        System.out.println(productPage.getSize());//每页行数
        System.out.println(productPage.getPages());//页数
    }

}