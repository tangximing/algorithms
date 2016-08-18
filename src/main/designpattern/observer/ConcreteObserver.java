package designpattern.observer;

/**
 * Created by tangxm on 2016/8/18.
 */
public class ConcreteObserver implements Observer {
  @Override
  public void update(String state) {
    System.out.println("状态更新为:" + state);
  }
}
