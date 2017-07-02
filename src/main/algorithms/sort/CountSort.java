package algorithms.sort;

/**
 * Created by tangxm on 2016/7/28.
 * 用于元素为0-k的数组
 * 主要思想：统计数组中各个元素出现的次数，从而统计每个元素应该在的位置，以达到排序的目的。
 * 时间复杂度 O(n + k)
 * 稳定
 * ref: http://www.cnblogs.com/developerY/p/3166462.html
 */
public class CountSort implements Sort<Integer>{
  @Override
  public void sort(Integer[] arrays) {
    int max = max(arrays);
    int[] count = new int[max + 1];
    Integer[] results = new Integer[arrays.length];

    /** 统计每个元素出现的次数*/
    for (int item: arrays) {
      count[item]++;
    }

    /** 统计各个元素应该所在的位置 */
    int sum = 0;
    for (int i = 0; i <= max; i++) {
      sum += count[i];
      count[i] = sum;
    }

    /** 倒序遍历将各个元素放入指定的位置，保证稳定性*/
    for (int i = arrays.length - 1; i >= 0; i--) {
      results[count[arrays[i]] - 1] = arrays[i];
      count[arrays[i]]--;
    }

    System.arraycopy(results, 0, arrays, 0, arrays.length);
  }

  private int max(Integer[] arrays) {
    int max = Integer.MIN_VALUE;
    for (int i : arrays) {
      max = Math.max(i, max);
    }
    return max;
  }
}
