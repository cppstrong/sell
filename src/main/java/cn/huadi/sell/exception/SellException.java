package cn.huadi.sell.exception;

import cn.huadi.sell.enums.ResultEnum;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName SellException.java
 * @Description TODO
 * @createTime 2020年02月23日 18:24:00
 */
public class SellException extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
