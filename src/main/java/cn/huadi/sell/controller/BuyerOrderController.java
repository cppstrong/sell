package cn.huadi.sell.controller;

import cn.huadi.sell.VO.ResultVO;
import cn.huadi.sell.converter.OrderForm2OrderDTOConverter;
import cn.huadi.sell.dto.OrderDTO;
import cn.huadi.sell.enums.ResultEnum;
import cn.huadi.sell.exception.SellException;
import cn.huadi.sell.form.OrderForm;
import cn.huadi.sell.service.BuyerService;
import cn.huadi.sell.service.OrderService;
import cn.huadi.sell.util.ResultVOUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author caipeng
 * @Description: 
 * 2020/2/28
 */
@RestController
@RequestMapping(value = "/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private BuyerService buyerService;
    
    //创建订单
    @RequestMapping("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】，参数不正确,orderForm = {}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】，购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openId,
                                         @RequestParam(value = "page",defaultValue = "0") Integer current,
                                         @RequestParam(value = "size",defaultValue = "10") Integer size){
        if (StringUtils.isEmpty(openId)) {
            log.error("【查询订单列表】 openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        Page page = new Page(current,size);
        Page<OrderDTO> orderDTOPage = orderService.selectList(openId, page);
        ResultVO resultVO = ResultVOUtil.success(orderDTOPage.getRecords());
        return resultVO;
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam(value = "openid") String openId,
                                     @RequestParam(value = "orderId") String orderId){
        OrderDTO orderDTO = buyerService.findOrderOne(openId, orderId);
        return ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam(value = "openid") String openId,
                       @RequestParam(value = "orderId") String orderId){
        buyerService.cancelOrder(openId,orderId);

        return ResultVOUtil.success();
    }
}
