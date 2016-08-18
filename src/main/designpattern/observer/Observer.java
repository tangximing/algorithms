package designpattern.observer;

/**
 * Created by tangxm on 2016/8/18.
 * 概念：主要有观察者和观察目标。当观察目标的状态发生变化，会通知已经注册的观察者更新状态
 *      一个观察目标可以注册多个观察者
 */
interface Observer {
  /**
   * 更新状态
   * @param state
   */
  void update(String state);
}
