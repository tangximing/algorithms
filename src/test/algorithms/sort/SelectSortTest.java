package algorithms.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tangxm on 2016/7/27.
 */
public class SelectSortTest extends SortTest {
  private SelectSort<Integer> selectSort;
  @Before
  public void init() {
    selectSort = new SelectSort<>();
  }
  @Test
  public void sort() throws Exception {
    selectSort.sort(arrays);
    selectSort.print(arrays);
  }

}