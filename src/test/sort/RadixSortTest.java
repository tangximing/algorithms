package sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tangxm on 2016/7/28.
 */
public class RadixSortTest extends SortTest {
  private RadixSort radixSort;

  @Before
  public void init() {
    radixSort = new RadixSort();
    arrays = new Integer[] {1,223,32,445,56,76,5432,3,5,78};
  }
  @Test
  public void sort() throws Exception {
    radixSort.sort(arrays);
    radixSort.print(arrays);
  }

}