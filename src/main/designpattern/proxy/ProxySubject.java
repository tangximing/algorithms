package designpattern.proxy;

/**
 * Created by tangxm on 2016/8/22.
 */
public class ProxySubject implements Subject {
  private RealSubject realSubject = new RealSubject();

  private void before() {
    System.out.println("Before Request");
  }

  @Override
  public void request() {
    before();
    realSubject.request();
    after();
  }

  private void after() {
    System.out.println("After Request");
  }
}
