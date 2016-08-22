package designpattern.singleton;

/**
 * Created by tangxm on 2016/8/17.
 * 当多个线程调用getInstance() 会创建多个实例
 */
public class Singleton {
  /**
   * 将构造函数声明为private,保证类外无法创建对象
   */
  private Singleton(){}
  private static Singleton singleton = null;

  /**
   * 需要声明为public，供外部调用；需要声明为static，因为类外没有对象
   * @return
   */
  public static Singleton getInstance() {
    if (singleton == null)
      singleton = new Singleton();
    return singleton;
  }
}
