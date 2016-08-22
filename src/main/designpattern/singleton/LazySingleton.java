package designpattern.singleton;

/**
 * Created by tangxm on 2016/8/17.
 * 并不完美：new Singleton()不是原子操作，主要分为三步：
 * 1. 给Instance分配内存
 * 2. 调用Singleton的构造函数来初始化成员变量
 * 3. 将instance对象指向分配的内存
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
   * 需要添加volatile保证多个线程能够正确处理，更重要的是禁止指令重排序。
   * 指令重排序：造成步骤2和3可能顺序变化，这样当1，3指向完，被线程2占用，此时对象还没执行步骤2，故而线程2使用对象的
   * 时候报错，添加volatile后，对instance的写操作先行发生于之后对其的读操作，故而只有在一个线程执行完1，3，2
   * （1，2，3）后，另外一个线程才能进行读
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
