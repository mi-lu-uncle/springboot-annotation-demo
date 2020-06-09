package com.gc.chainofresponsibility;

import lombok.extern.slf4j.Slf4j;

/**
 * 责任链模式:C责任点
 * @author gaochao
 * @create 2020-06-01 9:49
 */
@Slf4j
public class CResponsibility implements IResponsibility {
  @Override
  public void doSomething(String input, IResponsibility iResponsibility) {

    if ("C".equals(input)){
      //C责任点业务逻辑
      log.info("C Responsibility do something");
      return;
    }
    //当前没办法处理,让下一个责任点处理
    iResponsibility.doSomething(input, iResponsibility);
  }
}