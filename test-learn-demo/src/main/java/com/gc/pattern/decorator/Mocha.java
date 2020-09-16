package com.gc.pattern.decorator;

import java.math.BigDecimal;

/**
 * 摩卡调料类
 * @author gaochao
 * @create 2020-09-16 0:13
 */
public class Mocha extends CondimentDecorator {

  //记录被装饰者
  Beverage beverage;

  public Mocha(Beverage beverage){
    this.beverage = beverage;
    this.description = "Mocha";
  }

  //加上原有基础上的描述
  @Override
  public String getDescription() {
    return beverage.getDescription()+","+this.description;
  }

  @Override
  public BigDecimal cost() {
    return new BigDecimal(3).add(beverage.cost());
  }
}
