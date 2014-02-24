package com.bwang.join.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User: Brian Wang
 * Time: 1/12/14 11:16 PM
 */
public final class BeanHelper {
    public static Object getBean(String beanId) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("service.xml");
        return applicationContext.getBean(beanId);
    }
}
