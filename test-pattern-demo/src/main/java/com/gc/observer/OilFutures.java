package com.gc.observer;

/**
 * test : 利用 Observable 类和 Observer 接口实现原油期货的观察者模式实例。
 * @author gaochao
 * @create 2020-06-02 10:00
 */


import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * 目标:原油期货
 */
@Data
class OilFutures extends Observable {

  private float price;

  //触发器:邮件变动通知每个观察者
  public void change(float price){
    super.setChanged();
    super.notifyObservers(price);
    this.price=price;
  }

}


//具体观察者类：多方
class Bull implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    Float price=((Float)arg).floatValue();
    if(price>0)
    {
      System.out.println("油价上涨"+price+"元，多方高兴了！");
    }
    else
    {
      System.out.println("油价下跌"+(-price)+"元，多方伤心了！");
    }
  }
}

//具体观察者类：空方
class Bear implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    Float price=((Float)arg).floatValue();
    if(price>0)
    {
      System.out.println("油价上涨"+price+"元，空方伤心了！");
    }
    else
    {
      System.out.println("油价下跌"+(-price)+"元，空方开心了！");
    }
  }
}
