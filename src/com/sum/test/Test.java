package com.sum.test;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    static ApplicationContext appContext = null;
    static ApplicationContext appContext1 = null;

    private void createDynamicBean() {
        AutowireCapableBeanFactory factory = null;
        appContext = new ClassPathXmlApplicationContext("spring-bean.xml");
        appContext1 = new ClassPathXmlApplicationContext("spring-bean.xml");
        factory = appContext.getAutowireCapableBeanFactory();
        BeanDefinitionRegistry registry = (BeanDefinitionRegistry) factory;
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(SampleBean.class);
        beanDefinition.setAutowireCandidate(true);
        registry.registerBeanDefinition("sampleBean", beanDefinition);
        factory.autowireBeanProperties(this,
                AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
    }

    public static void main(String[] args) {
        Test dynamicBeanTest = new Test();
        dynamicBeanTest.createDynamicBean();
        SampleBean sampleBean = getBean(SampleBean.class);
        sampleBean.method1();
    }

    @SuppressWarnings("unchecked")
    private static <T> T getBean(Class <? extends T> type) {
        String beanName = type.getSimpleName();
        beanName = beanName.substring(0, 1).toLowerCase()
                + beanName.substring(1);
        return (T) appContext.getBean(beanName);
    }
}

class SampleBean {

    public void method1() {
        System.out.println("Method1");
    }
}