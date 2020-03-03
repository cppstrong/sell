package cn.huadi.sell.enums;

import lombok.Getter;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderStatusEnum.java
 * @Description TODO
 * @createTime 2020年02月23日 12:09:00
 */
@Getter
public enum OrderStatusEnum {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"已取消")
    ;
    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
