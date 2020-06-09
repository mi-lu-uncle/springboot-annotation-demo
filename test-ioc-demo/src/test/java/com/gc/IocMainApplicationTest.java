package com.gc;

import com.gc.ioc.FactoryBeanLearn;
import com.gc.ioc.IocMainConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaochao
 * @create 2020-05-18 0:15
 */
@Slf4j
public class IocMainApplicationTest {


  @Test
  public void test01(){
    AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(IocMainConfig.class);

    /** FactoryBean是一个能生产或修饰对象生成的工厂Bean。一个Bean如果实现了FactoryBean接口，
     * 那么根据该Bean的名称获取到的实际上是getObject()返回的对象，而不是这个Bean自身实例，
     * 如果要获取这个Bean自身实例，那么需要在名称前面加上'&'符号。 **/

    Object pig = ioc.getBean("pig", "哈士奇");

    //获取ioc容器对象(bean对象)
    FactoryBeanLearn bean = (FactoryBeanLearn)ioc.getBean("factoryBeanLearn");
    log.info("获取bean对象的msg为 {}",bean.getMsg());

    //获取FactoryBean对象
    FactoryBeanLearn bean1 = (FactoryBeanLearn)ioc.getBean("&factoryBeanLearn");
    log.info("获取FactoryBean对象的msg为 {}",bean1.getMsg());
    //关闭ioc容器
    ioc.close();
  }

}