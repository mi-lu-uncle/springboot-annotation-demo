package com.gc.pattern.decorator;

import java.math.BigDecimal;

/**
 * 浓缩咖啡类
 * @author gaochao
 * @create 2020-09-16 0:11
 */
public class Espresso extends Beverage {
  public Espresso(){
    description = "Espresso";
  }

  @Override
  public BigDecimal cost() {
    return new BigDecimal(7);
  }
}
