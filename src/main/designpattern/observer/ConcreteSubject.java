package designpattern.observer;

/**
 * Created by tangxm on 2016/8/18.
 */
public class ConcreteSubject extends Subject {
  @Override
  public void changeState(String state) {
    this.notifyObservers(state);
  }
}
