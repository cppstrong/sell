package cn.huadi.sell.controller;

import cn.huadi.sell.dto.OrderDTO;
import cn.huadi.sell.enums.ResultEnum;
import cn.huadi.sell.exception.SellException;
import cn.huadi.sell.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Lenovo
 * 2020/3/13
 * @version 1.0.0
 * @Description TODO
 */
@Controller
@RequestMapping("/pay")
public class PayController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/create")
    public ModelAndView create(@RequestParam("orderId") String orderId,
                               @RequestParam("returnUrl") String returnUrl){
        //1.查询订单
        OrderDTO orderDTO = orderService.selectOne(orderId);
        if (orderDTO == null){
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.发起支付
        return new ModelAndView("pay/create");

    }
}
