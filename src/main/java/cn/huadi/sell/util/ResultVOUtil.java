package cn.huadi.sell.util;

import cn.huadi.sell.VO.ResultVO;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ResultVOUtil.java
 * @Description TODO
 * @createTime 2020年02月23日 01:00:00
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success() {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setData(null);
        resultVO.setMessage("成功");
        return resultVO;
    }

    public static ResultVO error(Integer code, String massage) {
        ResultVO<Object> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMessage(massage);
        return resultVO;
    }

}
