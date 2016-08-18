package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxm on 2016/8/18.
 */
public abstract class Subject {
  /**
   * 用来保存注册的观察者
   */
  private List<Observer> observers = new ArrayList<>();

  /**
   * 添加一个观察者
   * @param observer
   */
  public void attach(Observer observer) {
    observers.add(observer);
    System.out.println("Attach an observer");
  }

  /**
   * 删除一个观察者
   * @param observer
   */
  public void detach(Observer observer) {
    observers.remove(observer);
    System.out.println("Detach an observer");
  }

  public void notifyObservers(String state) {
    for (Observer observer: observers) {
      observer.update(state);
    }
  }

  public abstract void changeState(String state);
}
