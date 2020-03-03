package cn.huadi.sell.service.impl;

import cn.huadi.sell.dto.OrderDTO;
import cn.huadi.sell.enums.ResultEnum;
import cn.huadi.sell.exception.SellException;
import cn.huadi.sell.service.BuyerService;
import cn.huadi.sell.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Lenovo
 * 2020/2/29
 * @version 1.0.0
 * @Description TODO
 */
@Slf4j
@Service
public class BuyerServiceImpl implements BuyerService {

    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        return orderDTO;
    }

    @Override
    public OrderDTO cancelOrder(String openId, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openId, orderId);
        if (orderDTO == null) {
            log.error("【取消订单】 查不到该订单，orderId = {}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner (String openId, String orderId) {
        OrderDTO orderDTO = orderService.selectOne(orderId);
        if (orderDTO == null) {
            return null;
        }
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(openId)) {
            log.error("【订单查询】订单的openid不一致, openid={},orderDTO={}",openId,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }

        return orderDTO;
    }
}
