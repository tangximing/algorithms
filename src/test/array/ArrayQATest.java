package array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/8/25.
 */
public class ArrayQATest {
  private ArrayQA arrayQA;
  private int[] arrays;

  @Before
  public void init() {
    arrayQA = new ArrayQA();
    arrays = new int[]{3,6,2,8,1,4,7,5,0};
  }

  @Test
  public void getK() throws Exception {
    System.out.println(arrayQA.getK(arrays, 6));
  }

}