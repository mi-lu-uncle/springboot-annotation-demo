package com.gc.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体目标(被观察者)
 * @author gaochao
 * @create 2020-06-01 17:30
 */
@Slf4j
public class ConcreteSubject extends Subject {

  @Override
  public void notifyObserver() {
    log.info("ConcreteSubject is changing");
    for (Object obs : observers){
      ((Observer)obs).response();
    }
  }
}
