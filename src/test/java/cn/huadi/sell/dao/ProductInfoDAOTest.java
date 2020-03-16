package cn.huadi.sell.dao;

import cn.huadi.sell.entity.ProductInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductDAOTest.java
 * @Description TODO
 * @createTime 2020年02月22日 13:30:00
 */
@SpringBootTest
class ProductInfoDAOTest {

    @Autowired
    private ProductInfoDAO dao;

    @Test
    @Transactional
    public void insert() {
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId("123457");
        productInfo.setProductName("花生粥");
        productInfo.setProductPrice(BigDecimal.valueOf(4.0));
        productInfo.setProductStock(100);
        productInfo.setProductDescription("香气扑鼻的花生粥！");
        productInfo.setProductIcon("http://xxxy.jpg");
        productInfo.setProductStatus(0);
        productInfo.setCategoryType(3);
        int result = dao.insert(productInfo);
        System.out.println(result);
    }

    @Test
    void update() {
        QueryWrapper wrapper = new QueryWrapper();

        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductStock(500);
        productInfo.setProductName("芒果冰");
        dao.update(productInfo, null);
    }

    @Test
    public void selectProductByProductStatus() {
        QueryWrapper<ProductInfo> wrapper = new QueryWrapper();
        wrapper.eq("product_status", Integer.valueOf(1));
        List<ProductInfo> productInfos = dao.selectList(wrapper);
        Assertions.assertNotEquals(0, productInfos);
    }
}