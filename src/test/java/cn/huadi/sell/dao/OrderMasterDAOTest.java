package cn.huadi.sell.dao;

import cn.huadi.sell.entity.OrderMaster;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderMasterDAOTest.java
 * @Description TODO
 * @createTime 2020年02月23日 13:16:00
 */
@SpringBootTest
class OrderMasterDAOTest {

    @Autowired
    private OrderMasterDAO orderMasterDAO;

    private final String OPENID = "001001";

    @Test
    public void insert() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123458");
        orderMaster.setBuyerName("张伟");
        orderMaster.setBuyerAddress("南宁市荔浦村");
        orderMaster.setBuyerPhone("12310050009");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMasterDAO.insert(orderMaster);
    }

    @Test
    public void updateById() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerName("老徐");
        orderMaster.setBuyerAddress("白沙镇老王村");
        orderMaster.setBuyerPhone("12310058589");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(6.3));
        orderMasterDAO.updateById(orderMaster);
    }

    @Test
    public void selectByBuyerOpenid() {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("buyer_openid", this.OPENID);
        Page<OrderMaster> page = orderMasterDAO.selectPage(new Page<OrderMaster>(1, 3), wrapper);
        Assertions.assertNotEquals(0, page.getRecords().size());
    }

}