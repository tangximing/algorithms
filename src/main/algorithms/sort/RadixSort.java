package algorithms.sort;

/**
 * Created by tangxm on 2016/7/28.
 * 主要思想：先通过个位大小将数组排序，在通过百位大小将元素排序，.....
 * 时间复杂度：O(d * n)，d为数的位数
 * 稳定
 */
public class RadixSort implements Sort<Integer> {
  @Override
  public void sort(Integer[] arrays) {
    int digit = digit(arrays); //最大元素的位数
    int cur = 1;
    int length = arrays.length;
    int[][] bucket = new int[10][length]; //排序桶，将当前位相同的元素放入同一个桶中
    int[] count = new int[10]; //用于每个桶元素的计数

    while (cur < digit) {
      for (int item: arrays) { // 根据当前位，将元素放入对应的桶中
        int position = (item / cur) % 10;
        bucket[position][count[position]] = item;
        count[position]++;
      }

      int k = 0;
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < count[i]; j++) {
          arrays[k++] = bucket[i][j];
        }
        count[i] = 0;
      }

      cur *= 10;
    }
  }

  private int digit(Integer[] arrays) {
    int digit = 1;
    int max = Integer.MIN_VALUE;
    for (int item: arrays) {
      max = Math.max(item, max);
    }

    while (max / digit != 0) {
      digit *= 10;
    }

    return digit;
  }
}
