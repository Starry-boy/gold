package com.jiaxc.gold.log.autoconfigure;

import com.jiaxc.gold.log.filter.BuriedPointFilter;
import com.jiaxc.gold.log.service.BuriedPointAble;
import com.jiaxc.gold.log.service.adpater.impl.DefaultBuriedPoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author ratel
 * @version 1.0
 * @description:
 * @date 2021/5/9 9:59
 */
@Slf4j
@Configuration
public class WebAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(FilterRegistrationBean.class)
    public FilterRegistrationBean filterRegistrationBean(@Autowired BuriedPointFilter buriedPointFilter){
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(buriedPointFilter);
        log.debug("registration buriedPointFilter success");
        return filterRegistrationBean;
    }

    @Bean
    @ConditionalOnMissingBean(BuriedPointAble.class)
    public BuriedPointAble buriedPointAble(){
        DefaultBuriedPoint defaultBuriedPoint = new DefaultBuriedPoint();
        log.debug("registration defaultBuriedPoint success");
        return defaultBuriedPoint;
    }

}
