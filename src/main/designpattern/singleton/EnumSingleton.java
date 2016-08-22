package designpattern.singleton;

/**
 * Created by tangxm on 2016/8/22.
 */
public enum EnumSingleton {
  INSTANCE;
  public EnumSingleton getInstance() {
    return INSTANCE;
  }
  public void print() {
    System.out.println("enum singleton");
  }
}
