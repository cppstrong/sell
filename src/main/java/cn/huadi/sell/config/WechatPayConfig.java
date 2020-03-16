package cn.huadi.sell.config;

import com.lly835.bestpay.config.WxPayConfig;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 * 2020/3/14
 * @version 1.0.0
 * @Description TODO
 */
@Component
public class WechatPayConfig {

    @Autowired
    WechatAccountConfig wechatAccountConfig;

    @Bean
    public BestPayServiceImpl bestPayService() {
        WxPayConfig wxPayH5Config = new WxPayConfig();
        wxPayH5Config.setAppId(wechatAccountConfig.getMpAppId());
        wxPayH5Config.setAppSecret(wechatAccountConfig.getMpSecret());
        wxPayH5Config.setKeyPath(wechatAccountConfig.getKeyPath());
        wxPayH5Config.setMchId(wechatAccountConfig.getMchId());
        wxPayH5Config.setMchKey(wechatAccountConfig.getMchKey());
        wxPayH5Config.setNotifyUrl(wechatAccountConfig.getNotifyUrl());

        BestPayServiceImpl bestPayService = new BestPayServiceImpl();
        bestPayService.setWxPayConfig(wxPayH5Config);
        return bestPayService;
    }

}
