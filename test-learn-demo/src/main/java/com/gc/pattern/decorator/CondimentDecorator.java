package com.gc.pattern.decorator;

/**
 * 调料装饰着抽象类
 * @author gaochao
 * @create 2020-09-16 0:12
 */
public abstract class CondimentDecorator extends Beverage {

  @Override
  public abstract String getDescription();

}
