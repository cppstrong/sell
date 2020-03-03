package cn.huadi.sell.converter;

import cn.huadi.sell.dto.OrderDTO;
import cn.huadi.sell.entity.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderMaster2OrderDTOConverter.java
 * @Description TODO
 * @createTime 2020年02月25日 17:19:00
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return  orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->
                convert(e)
        ).collect(Collectors.toList());
    }
}
