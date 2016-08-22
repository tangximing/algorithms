package proxy;

/**
 * Created by tangxm on 2016/8/22.
 */
public class RealSubject implements Subject {
  @Override
  public void request() {
    System.out.println("request in realSubject");
  }
}
