package javaresearch.dynamicProxy;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by tangxm on 2016/8/22.
 */
public class Client {
  @Test
  public void test() {
    Subject realSubject = new RealSubject();

    InvocationHandler handler = new ProxyHandler(realSubject);

    Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
            realSubject.getClass().getInterfaces(), handler);
    subject.rent();
    subject.hello("tangxm");
  }
}