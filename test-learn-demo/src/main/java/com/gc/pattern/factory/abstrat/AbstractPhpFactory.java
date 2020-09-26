package com.gc.pattern.factory.abstrat;

/**
 * java 产品族抽象工厂
 * @author gaochao
 * @create 2020-09-20 0:30
 */
public class AbstractPhpFactory implements AbstractFactory  {
  @Override
  public INote creatNote() {
    return new PhpNote();
  }

  @Override
  public ISource creatSource() {
    return new JavaSource();
  }

  @Override
  public IVideo creatVideo() {
    return new JavaVideo();
  }
}
