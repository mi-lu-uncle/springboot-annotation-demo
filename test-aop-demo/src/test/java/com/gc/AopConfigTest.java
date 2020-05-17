package com.gc;

import com.gc.aop.AopConfig;
import com.gc.aop.MacthCustom;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author gaochao
 * @create 2020-05-18 0:13
 */
@SpringBootTest
public class AopConfigTest {

  @Test
  public void test(){
    AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(AopConfig.class);
    //要通过ioc容器获得对象才会被aop代理,new 的对象无法被aop代理.
    MacthCustom macthCustom = ioc.getBean(MacthCustom.class);
    macthCustom.match(2, 1);

  }
}