package designpattern.singleton;

/**
 * Created by tangxm on 2016/8/17.
 */
public class LazySingleton {
  private static LazySingleton instance = null;
  private LazySingleton(){}

  /**
   * 添加关键字synchronized, 以处理多个线程同时访问的问题，但是锁定整个getInstance方法，性能降低
   * @return
   */
  public synchronized static LazySingleton getInstance(){
    if (instance == null)
      instance = new LazySingleton();
    return instance;
  }

  /**
   * 需要添加volatile保证多个线程能够正确处理
   */
  private volatile static LazySingleton newInstance = null;
  /**
   * 优化：只需要锁定new LazySingleton()即可。
   * 采用双重检查锁定：因为可能存在多个线程同时进入if语句，这样当一个线程创建好instance后，其他线程并不知道
   * 对象已经创建好
   * @return
   */
  public static  LazySingleton getNewInstance(){
    if (newInstance == null) {
      synchronized (LazySingleton.class) {
        if (newInstance == null) {
          newInstance = new LazySingleton();
        }
      }
    }
    return newInstance;
  }
}
