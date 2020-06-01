package com.gc.observer;

import org.junit.jupiter.api.Test;

/**
 * @author gaochao
 * @create 2020-06-01 17:34
 */
public class ConcreteSubjectTest {

  @Test
  void notifyObserver() {

    Subject subject = new ConcreteSubject();
    Observer observer1 = new ConcreteObserver1();
    Observer observer2 = new ConcreteObserver2();
    subject.add(observer1).add(observer2);
    subject.notifyObserver();

  }
}