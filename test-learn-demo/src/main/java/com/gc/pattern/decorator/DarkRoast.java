package com.gc.pattern.decorator;

import java.math.BigDecimal;

/**
 * 深焙咖啡类
 * @author gaochao
 * @create 2020-09-16 0:09
 */
public class DarkRoast extends Beverage {

  public DarkRoast() {
    description = "DarkRoast";
  }

  @Override
  public BigDecimal cost() {
    return new BigDecimal(3);
  }
}
