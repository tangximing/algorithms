package list;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/8/25.
 */
public class ListQATest {
  private ListQA<Integer> listQA;

  @Before
  public void init() {
    listQA = new ListQA<>();
    Integer[] arrays = {3,6,2,8,1,4,7,5,0};
    listQA.headBuild(arrays);
  }
  @Test
  public void print() throws Exception {
    listQA.print();
  }

}