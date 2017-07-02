package algorithms.string;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tangxm on 2016/8/1.
 */
public class KMPTest {
  private KMP kmp;
  private String str;
  private String pattern;

  @Before
  public void init() {
    kmp = new KMP();
    str = "BBC ABCDAB ABCDABCDABDE";
    pattern = "ABCDABD";
  }
  @Test
  public void getNext() throws Exception {
    int[] next = kmp.getNext("DABCDABDE");
    for (int i: next)
      System.out.print(i + " ");
  }

  @Test
  public void kmp() throws Exception {
    assertTrue(kmp.kmp(str, pattern) > 0);
    System.out.println(kmp.kmp(str, pattern));
  }

}