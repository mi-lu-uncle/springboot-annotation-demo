package com.gc.observer;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author gaochao
 * @create 2020-06-01 17:34
 */
@Slf4j
public class ConcreteSubjectTest {

  @Test
  void observerTest() {

    Subject subject = new ConcreteSubject();
    Observer observer1 = new ConcreteObserver1();
    Observer observer2 = new ConcreteObserver2();
    subject.add(observer1).add(observer2);
    subject.notifyObserver();

  }

  @Test
  void rateTest(){
    Rate rate = new RMBRate();
    rate.addCompany(new ImportCompany()).addCompany(new OutputCompany());
    rate.notifyCompany(1);
    rate.notifyCompany(-11);
  }

  @Test
  void ringEventTest(){
    BellEventSource source = new BellEventSource();

    source.addPersonListener(new TeacherEvenListener()).addPersonListener(new StudentEvenListener());

    source.ring(true);
    try {
      log.info("线程睡眠3s,模拟上课....");
      TimeUnit.SECONDS.sleep(3);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    source.ring(false);
  }


  @Test
  void OilFuturesTest(){
    OilFutures futures = new OilFutures();
    futures.addObserver(new Bear());
    futures.addObserver(new Bull());
    futures.change(1);
    futures.change(-2);

  }
}