package sort;

import sort.Sort;

/**
 * Created by tangxm on 2016/7/27.
 * 主要思想 通过一个target元素将数组分成两部分，一部分比target小，一部分比target大，然后递归对两个部分进行排序
 * 时间复杂度  最好：O（n * log(n)）, 最坏：O（n^2）, 平均：O（n * log(n)）
 * 空间复杂度  O（log(n)）
 * 不稳定
 */
public class QuickSort<T extends Comparable<T>> implements Sort<T> {
  @Override
  public void sort(T[] arrays) {
    quickSort(arrays, 0, arrays.length - 1);
  }

  private void quickSort(T[] arrays, int low, int high) {
    if (low < high) {
      T target = arrays[low];
      int left = low, right = high;
      while (left < right) {
        while (right > left && arrays[right].compareTo(target) >= 0) right--;
        arrays[left] = arrays[right];
        while (right > left && arrays[left].compareTo(target) <= 0) left++;
        arrays[right] = arrays[left];
      }
      arrays[left] = target;
      quickSort(arrays, low, left - 1);
      quickSort(arrays, left + 1, high);
    }
  }
}
