package cn.huadi.sell.service;

import cn.huadi.sell.dto.OrderDTO;

/**
 * @author caipeng
 * 2020/2/29
 * @version 1.0.0
 * @Description 买家
 */
public interface BuyerService {

    OrderDTO findOrderOne(String openId,String orderId);

    OrderDTO cancelOrder(String openId,String orderId);

}
