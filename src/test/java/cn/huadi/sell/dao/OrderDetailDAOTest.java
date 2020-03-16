package cn.huadi.sell.dao;

import cn.huadi.sell.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderDetailDAOTest.java
 * @Description TODO
 * @createTime 2020年02月23日 17:24:00
 */
@SpringBootTest
class OrderDetailDAOTest {

    @Autowired
    private OrderDetailDAO orderDetailDAO;

    @Test
    public void insert() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId("123457");
        orderDetail.setDetailId("11112");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋粥");
        orderDetail.setProductIcon("http://xxxx.jpg");
        orderDetail.setProductPrice(BigDecimal.valueOf(3.2));
        orderDetail.setProductQuantity(2);

        int result = orderDetailDAO.insert(orderDetail);
        assertNotEquals(0, result);
    }

    @Test
    public void selectByOrderId() {
        OrderDetail orderDetail = orderDetailDAO.selectById("11111");
        Assertions.assertNotNull(orderDetail);
    }


}