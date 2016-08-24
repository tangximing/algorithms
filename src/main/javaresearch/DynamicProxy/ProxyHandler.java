package javaresearch.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by tangxm on 2016/8/22.
 */
public class ProxyHandler implements InvocationHandler {
  private Subject subject;
  public ProxyHandler(Subject subject) {
    this.subject = subject;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    before();
    method.invoke(subject, args);
    after();
    return null;
  }

  private void before() {
    System.out.println("Before rent house");
  }

  private void after() {
    System.out.println("After rent house");
  }
}
