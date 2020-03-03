package cn.huadi.sell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/** 扫描mybatis mapper接口所在的包 ，指定多个包BasePackages={"包路径1"，"包路径2"}*/
@MapperScan(basePackages = "cn.huadi.sell.dao")
public class SellApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellApplication.class, args);
    }

}
