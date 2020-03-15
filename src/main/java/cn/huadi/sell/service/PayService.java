package cn.huadi.sell.service;

import cn.huadi.sell.dto.OrderDTO;

/**
 * @author Lenovo
 * 2020/3/13
 * @version 1.0.0
 * @Description TODO
 */
public interface PayService {

    void create(OrderDTO orderDTO);

}
