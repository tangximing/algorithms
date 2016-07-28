package sort;

import org.junit.Before;
import org.junit.Test;

import sort.QuickSort;
import sort.SortTest;

/**
 * Created by tangxm on 2016/7/27.
 */
public class QuickSortTest extends SortTest {
  private QuickSort<Integer> quickSort;
  @Before
  public void init() {
    quickSort = new QuickSort<>();
  }
  @Test
  public void sort() throws Exception {
    quickSort.sort(arrays);
    quickSort.print(arrays);
  }

}