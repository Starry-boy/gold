package com.jiaxc.gold.log.filter;

import com.jiaxc.gold.log.constist.enums.BuriedPointTypeEnum;
import com.jiaxc.gold.log.factory.BuriedPointFactory;
import com.jiaxc.gold.log.service.BuriedPointAble;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ratel
 * @version 1.0
 * @description: 埋点切面，用于统计用户访问数等信息
 * @date 2021/5/9 9:35
 */

@Component
public class BuriedPointFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        BuriedPointAble buriedPointAble = BuriedPointFactory.getBuriedPointAble(BuriedPointTypeEnum.DEFAULT);


    }

    @Override
    public void destroy() {

    }
}
