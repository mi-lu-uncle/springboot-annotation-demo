package com.gc.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象目标(抽象被观察者)
 * @author gaochao
 * @create 2020-06-01 17:16
 */
public abstract class Subject {

  /**
   * 观察者列表
   */
  protected List<Observer> observers = new ArrayList<>();

  /**
   * 新增观察者
   * @param observer
   */
  public Subject add(Observer observer){
    observers.add(observer);
    return this;
  }

  /**
   * 删除观察者
   * @param observer
   */
  public void remove(Observer observer){
    observers.remove(observer);
  }

  /**
   * 通知观察者方法
   */
  abstract void notifyObserver();

}
