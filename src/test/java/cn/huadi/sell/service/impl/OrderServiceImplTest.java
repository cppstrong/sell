package cn.huadi.sell.service.impl;

import cn.huadi.sell.dto.OrderDTO;
import cn.huadi.sell.entity.OrderDetail;
import cn.huadi.sell.enums.OrderStatusEnum;
import cn.huadi.sell.enums.PayStatusEnum;
import cn.huadi.sell.service.OrderService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderServiceImplTest.java
 * @Description TODO
 * @createTime 2020年02月25日 01:31:00
 */
@SpringBootTest
@Slf4j
class OrderServiceImplTest {

    @Autowired
    private OrderService orderService;
    private final String BUYER_OPENID = "001001";
    private final String orderId = "1582564473351844803";

    @Test
    void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("廖师兄");
        orderDTO.setBuyerAddress("幕课网");
        orderDTO.setBuyerPhone("123456789012");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车
        List<OrderDetail> orderDetailList = new ArrayList<>();
        OrderDetail o1 = new OrderDetail();
        o1.setProductId("123456");
        o1.setProductQuantity(1);

        OrderDetail o2 = new OrderDetail();
        o2.setProductId("123457");
        o2.setProductQuantity(2);

        orderDetailList.add(o1);
        orderDetailList.add(o2);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】result={}", result);
        Assertions.assertNotNull(result);
    }

    @Test
    void selectOne() {
        OrderDTO result = orderService.selectOne(orderId);
        log.info("【查询单个订单】,result={}", result);
        Assertions.assertEquals(orderId, result.getOrderId());
    }

    @Test
    void selectList() {
        Page<OrderDTO> result = orderService.selectList(BUYER_OPENID, new Page(1, 3));
        log.info("【订单列表】，result={}", result.getRecords());
        Assertions.assertNotEquals(0, result.getRecords().size());
    }

    @Test
    void cancel() {
        OrderDTO orderDTO = orderService.selectOne(orderId);
        OrderDTO result = orderService.cancel(orderDTO);
        Assertions.assertEquals(OrderStatusEnum.CANCEL.getCode(), result.getOrderStatus());
    }

    @Test
    void finish() {
        OrderDTO orderDTO = orderService.selectOne(orderId);
        OrderDTO result = orderService.finish(orderDTO);
        Assertions.assertEquals(OrderStatusEnum.FINISHED.getCode(), result.getOrderStatus());
    }

    @Test
    void paid() {
        OrderDTO orderDTO = orderService.selectOne(orderId);
        OrderDTO result = orderService.paid(orderDTO);
        Assertions.assertEquals(PayStatusEnum.SUCCESS.getCode(), result.getPayStatus());
    }
}