package algorithms.sort;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by tangxm on 2016/7/27.
 */
public class InsertSortTest extends SortTest {
  private InsertSort<Integer> insertSort;
  @Before
  public void init() {
    insertSort = new InsertSort<>();
  }
  @Test
  public void sort() throws Exception {
    insertSort.sort(arrays);
    insertSort.print(arrays);
  }

}