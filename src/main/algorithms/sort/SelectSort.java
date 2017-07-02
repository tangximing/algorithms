package algorithms.sort;

/**
 * Created by tangxm on 2016/7/27.
 * 主要思想 每次选择最小的元素放在数组前面
 * 时间复杂度  最好：O（n^2）, 最坏：O（n^2）, 平均：O（n^2）
 * 空间复杂度  O（1）
 * 不稳定
 */
public class SelectSort<T extends Comparable<T>> implements Sort<T> {
  @Override
  public void sort(T[] arrays) {
    int length = arrays.length;
    for (int i = 0; i < length - 1; i++) {
      int min = i;
      for (int j = i; j < length; j++) {
        if (arrays[j].compareTo(arrays[min]) < 0) {
          min = j;
        }
      }
      T tmp = arrays[i];
      arrays[i] = arrays[min];
      arrays[min] = tmp;
    }
  }
}
