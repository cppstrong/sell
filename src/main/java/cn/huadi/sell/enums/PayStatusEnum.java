package cn.huadi.sell.enums;

import lombok.Getter;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName PayStatusEnum.java
 * @Description 支付状态
 * @createTime 2020年02月23日 12:14:00
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付完成");
    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
