package designpattern.observer;

import org.junit.Test;

/**
 * Created by tangxm on 2016/8/18.
 */
public class Client {
  @Test
  public void test() {
    Subject subject = new ConcreteSubject();
    Observer observer = new ConcreteObserver();
    subject.attach(observer);
    subject.changeState("new state");
  }
}