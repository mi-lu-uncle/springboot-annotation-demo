package com.gc.pattern.decorator;

import java.math.BigDecimal;

/**
 * 饮料抽象类
 * @author gaochao
 * @create 2020-09-16 0:04
 */
public abstract class Beverage {

  String description = "Unknown Beverage";

  public String getDescription(){
    return description;
  }

  /**
   * 花费的钱
   * @return
   */
  public abstract BigDecimal cost();

  public static void main(String[] args) {
    //冲调一杯Decaf
    Beverage decaf = new Decaf();
    //加 奶泡调料类
    decaf = new Whip(decaf);
    //加 豆浆
    decaf = new Soy(decaf);

    System.out.println("decaf.getDescription() = " + decaf.getDescription());
    System.out.println(decaf.cost());


  }
}
