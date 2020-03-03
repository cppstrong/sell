package cn.huadi.sell.VO;

import lombok.Data;

/**
 * @author 蔡鹏
 * @version 1.0.0
 * @ClassName ResultOV.java
 * @Description http请求返回的最外层对象
 * @createTime 2020年02月22日 18:16:00
 */
@Data
public class ResultVO<T> {

    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String message;

    /** 具体内容. */
    private T Data;

}
