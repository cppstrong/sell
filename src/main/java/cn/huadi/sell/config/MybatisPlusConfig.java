package cn.huadi.sell.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author caipeng
 * @version 1.0.0
 * @ClassName MybatisPlusConfig.java
 * @Description Mybatis plus 的分页插件配置类
 * @createTime 2020年02月19日 19:43:00
 */
@Configuration
@EnableTransactionManagement
@MapperScan("cn/huadi/sell/dao")
public class MybatisPlusConfig {

    /**
     * @description 分页插件
     * @author caipeng
     * @updateTime
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

}
