package array;

import org.junit.Before;
import org.junit.Test;

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

  @Test
  public void isLeak() {
    int[][] arrays = {
            {1, 0, 1, 1, 0},
            {0, 0, 1, 0, 0},
            {0, 1, 0, 0, 1},
            {1, 0, 0, 1, 0}
    };
    System.out.println(arrayQA.isLeak(arrays));
  }

  @Test
  public void getMaxZero() {
    int[] arrays = {1,1,-1,1,-1,-1,-1};
    System.out.println(arrayQA.getMaxZero(arrays));
  }
}