package com.gc.ioc.circulardependency;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaochao
 * @create 2020-06-09 11:25
 */
public class CircularDependencyConfigTest {


  @Test
  public void test(){
    AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(CircularDependencyConfig.class);

    CircularDependencyB b = ioc.getBean(CircularDependencyB.class);
    b.getA();
    /**
     * 关闭循环依赖
     */
//    AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext();
//    ioc.register(CircularDependencyConfig.class);
//    AbstractAutowireCapableBeanFactory beanFactory = (AbstractAutowireCapableBeanFactory) ioc.getBeanFactory();
//    beanFactory.setAllowCircularReferences(Boolean.FALSE);
//    ioc.refresh();

  }

}