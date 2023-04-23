package com.example.recovery.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 非容器控制类,调用bean的工具类
 * @author tulane
 * @version 创建时间：2017年11月29日  下午5:41:19
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    public static ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        SpringContextUtil.ctx = ctx;
    }

    @SuppressWarnings("unchecked") //强制转型
	public static <T> T getBean(String name) {
        return (T) ctx.getBean(name);
    }
    
    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return (T) ctx.getBean(clazz);
    }
}
