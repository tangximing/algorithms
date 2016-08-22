package proxy;

import org.junit.Test;

/**
 * Created by tangxm on 2016/8/22.
 */
public class SubjectTest {
  @Test
  public void test() {
    Subject subject = new ProxySubject();
    subject.request();
  }
}