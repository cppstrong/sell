package cn.huadi.sell.service;

import cn.huadi.sell.dto.OrderDTO;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderService.java
 * @Description TODO
 * @createTime 2020年02月23日 17:43:00
 */
public interface OrderService {

    /**
     * 创建订单 .
     */
    OrderDTO create(OrderDTO orderDTO);

    /**
     * 查询单个订单 .
     */
    OrderDTO selectOne(String orderId);

    /**
     * 查询订单列表 .
     */
    Page<OrderDTO> selectList(String openId, Page page);

    /**
     * 取消订单 .
     */
    OrderDTO cancel(OrderDTO orderDTO);

    /**
     * 完结订单 .
     */
    OrderDTO finish(OrderDTO orderDTO);

    /**
     * 支付订单 .
     */
    OrderDTO paid(OrderDTO orderDTO);

}
