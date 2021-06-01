package com.jiaxc.gold.log.autoconfigure;

import com.jiaxc.gold.log.aspect.TradeLogAspect;
import com.jiaxc.gold.log.service.APILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ratel
 * @version 1.0
 * @description: 日志自动配置
 * @date 2021/4/18 10:14
 */
@Configuration
public class LogAutoConfiguration {

    @Bean
    public TradeLogAspect apiLogAspect(@Autowired(required = false) APILogService apiLogService){
        TradeLogAspect tradeLogAspect = new TradeLogAspect();
        tradeLogAspect.setApiLogService(apiLogService);
        return tradeLogAspect;
    }
}
