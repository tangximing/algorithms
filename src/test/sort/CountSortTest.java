package sort;

import org.junit.Before;
import org.junit.Test;

import sort.CountSort;
import sort.SortTest;

/**
 * Created by tangxm on 2016/7/28.
 */
public class CountSortTest extends SortTest {
  private CountSort countSort;
  @Before
  public void init() {
    arrays = new Integer[]{3,6,2,8,1,4,7,5,0,0,2,4,5};
    countSort = new CountSort();
  }
  @Test
  public void sort() throws Exception {
    countSort.sort(arrays);
    countSort.print(arrays);
  }

}