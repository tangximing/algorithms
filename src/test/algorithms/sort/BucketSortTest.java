package algorithms.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by tangxm on 2016/8/26.
 */
public class BucketSortTest extends SortTest {
  @Test
  public void sort() throws Exception {
    int n = 100;
    Random random = new Random();
    arrays = new Integer[n];
    for (int i = 0; i < n; i++) {
      arrays[i] = random.nextInt(99) + 1;
    }
    BucketSort bucketSort = new BucketSort(10);
    bucketSort.print(arrays);
    bucketSort.sort(arrays);
    bucketSort.print(arrays);
  }

}