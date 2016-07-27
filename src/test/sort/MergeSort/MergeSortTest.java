package sort.MergeSort;

import org.junit.Before;
import org.junit.Test;

import sort.SortTest;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/7/27.
 */
public class MergeSortTest extends SortTest {
  private MergeSort<Integer> mergeSort;
  @Before
  public void init() {
    mergeSort = new MergeSort<>();
  }
  @Test
  public void sort() throws Exception {
    mergeSort.sort(arrays);
    mergeSort.print(arrays);
  }

}