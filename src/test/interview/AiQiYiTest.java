package interview;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/8/23.
 */
public class AiQiYiTest {
  private AiQiYi aiQiYi;
  @Before
  public void init() {
    aiQiYi = new AiQiYi();
  }
  @Test
  public void getK() throws Exception {
    int[] arrays = {3,6,2,8,1,4,7,5,0};
    System.out.println(aiQiYi.getK(arrays, 6));
  }

}