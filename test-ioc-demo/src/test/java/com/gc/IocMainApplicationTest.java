package com.gc;

import com.gc.ioc.IocMainConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaochao
 * @create 2020-05-18 0:15
 */
public class IocMainApplicationTest {

  @Test
  public void test01(){
    AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(IocMainConfig.class);
    //获取ioc容器对象
    //Object car = ioc.getBean("gcCar");
    //关闭ioc容器
    ioc.close();
  }

}