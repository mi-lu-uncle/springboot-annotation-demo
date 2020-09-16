package com.gc.pattern.decorator;

import java.math.BigDecimal;

/**
 * 豆浆调料类
 * @author gaochao
 * @create 2020-09-16 0:13
 */
public class Soy extends CondimentDecorator {

  //记录被装饰者
  Beverage beverage;

  public Soy(Beverage beverage){
    this.beverage = beverage;
    this.description = "Soy";
  }

  //加上原有基础上的描述
  @Override
  public String getDescription() {
    return beverage.getDescription()+"+"+this.description;
  }

  @Override
  public BigDecimal cost() {
    return new BigDecimal(1).add(beverage.cost());
  }
}
