package com.gc.pattern.observer;

import lombok.extern.slf4j.Slf4j;

/**
 * 具体观察者1
 * @author gaochao
 * @create 2020-06-01 17:14
 */
@Slf4j
public class ConcreteObserver2 implements Observer {

  @Override
  public void response() {
    log.info("ConcreteObserver2 response...");

  }
}
