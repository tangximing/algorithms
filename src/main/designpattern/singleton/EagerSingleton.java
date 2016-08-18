package designpattern.singleton;

/**
 * Created by tangxm on 2016/8/17.
 */
public class EagerSingleton {
  /**
   * 在类加载的时候，就会产生一个实例
   */
  private static final EagerSingleton instance = new EagerSingleton();
  private EagerSingleton(){}

  public static EagerSingleton getInstance() {
    return instance;
  }
}
