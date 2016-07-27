package sort.BubbleSort;

import org.junit.Before;
import org.junit.Test;

import sort.SortTest;

/**
 * Created by tangxm on 2016/7/27.
 */
public class BubbleSortTest extends SortTest {
  private BubbleSort<Integer> bubbleSort;
  @Before
  public void init() {
    bubbleSort = new BubbleSort<>();
  }
  @Test
  public void sort() throws Exception {
    bubbleSort.sort(arrays);
    bubbleSort.print(arrays);
  }

  @Test
  public void betterSort() throws Exception {
    bubbleSort.sort(arrays);
    bubbleSort.print(arrays);
  }

}