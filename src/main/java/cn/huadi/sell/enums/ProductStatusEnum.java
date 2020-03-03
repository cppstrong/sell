package cn.huadi.sell.enums;

import lombok.Getter;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ProductStatusEnum.java
 * @Description TODO
 * @createTime 2020年02月22日 15:08:00
 */
@Getter
public enum ProductStatusEnum {

    UP(0,"上架"),
    DOWN(1,"下架")
    ;

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
