package sort.ShellSort;

import org.junit.Before;
import org.junit.Test;

import sort.SortTest;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/7/27.
 */
public class ShellSortTest extends SortTest {
  private ShellSort<Integer> shellSort;
  @Before
  public void init() {
    shellSort = new ShellSort<>();
  }
  @Test
  public void sort() throws Exception {
    shellSort.sort(arrays);
    shellSort.print(arrays);
  }

}