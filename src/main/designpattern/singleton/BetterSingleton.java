package designpattern.singleton;

/**
 * Created by tangxm on 2016/8/17.
 */
public class BetterSingleton {
  private BetterSingleton(){}

  /**
   * 使用静态内部类，相比于Singleton方式，将instance的初始化延迟到getInstance方法调用的时候
   */
  private static class HolderClass {
    private final static BetterSingleton instance = new BetterSingleton();
  }

  public BetterSingleton getIntance() {
    return HolderClass.instance;
  }
}
