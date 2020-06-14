package com.gc.decorator;

import org.junit.jupiter.api.Test;

class DecoratorTest {

  @Test
  public void test01(){

    //原味咖啡
    Coffee coffee = new SimpleCoffee();

    //牛奶+椰果
    coffee = new WithMike(coffee);
    coffee = new WithSugar(coffee);
    System.out.println(coffee.getDesc());
    System.out.println(coffee.getPrice());

    //摩卡咖啡
    Coffee moka = new MokaCoffee();

    moka = new WithSugar(moka);
    System.out.println(moka.getDesc());
    System.out.println(moka.getPrice());

  }

}