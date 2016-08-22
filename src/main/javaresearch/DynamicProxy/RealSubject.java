package javaresearch.DynamicProxy;

/**
 * Created by tangxm on 2016/8/22.
 */
public class RealSubject implements Subject {
  @Override
  public void rent() {
    System.out.println("I want to rent my house");
  }

  @Override
  public void hello(String str) {
    System.out.println("hello: " + str);
  }
}
