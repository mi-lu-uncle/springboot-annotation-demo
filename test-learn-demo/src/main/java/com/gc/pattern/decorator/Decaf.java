package com.gc.pattern.decorator;

import java.math.BigDecimal;

/**
 * 低咖啡因咖啡类
 * @author gaochao
 * @create 2020-09-16 0:10
 */
public class Decaf extends Beverage {

  public Decaf(){
    description = "Decaf";
  }

  @Override
  public BigDecimal cost() {
    return new BigDecimal(2);
  }
}
