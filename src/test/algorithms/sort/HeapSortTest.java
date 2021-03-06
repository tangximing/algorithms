package algorithms.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tangxm on 2016/7/27.
 */
public class HeapSortTest extends SortTest{
  private HeapSort<Integer> heapSort;
  @Before
  public void init() throws Exception {
    heapSort = new HeapSort<>();
  }

  @Test
  public void sort() throws Exception {
    heapSort.sort(arrays);
    heapSort.print(arrays);
  }

}