package com.gc.chainofresponsibility;

import org.junit.Test;

/**
 * 责任链模式:测试类
 * @author gaochao
 * @create 2020-06-01 10:22
 */
public class ResponsibilityChainTest {

  @Test
  public void test(){
    String input = "B";
    ResponsibilityChain chain = new ResponsibilityChain()
            .addChain(new AResponsibility())
            .addChain(new BResponsibility())
            .addChain(new CResponsibility());
    chain.doSomething(input, chain);
  }

}