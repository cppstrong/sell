package cn.huadi.sell.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName OrderForm.java
 * @Description TODO
 * @createTime 2020年02月28日 00:06:00
 */
@Data
public class OrderForm {

    /*
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /*
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /*
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /*
     * 买家微信openid
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /*
     * 购物车
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
