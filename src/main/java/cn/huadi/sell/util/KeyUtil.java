package cn.huadi.sell.util;

import java.util.Random;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName KeyUtil.java
 * @Description 生成唯一主键
 * @createTime 2020年02月24日 02:10:00
 */
public class KeyUtil {

    /**
     * @description 生成唯一主键  格式： 时间 + 随机数
     * @author caipeng
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
