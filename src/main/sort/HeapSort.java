package sort;

/**
 * Created by tangxm on 2016/7/27.
 * 主要思想 通过建立最大堆实现
 * 时间复杂度  最好：O（n * log(n)）, 最坏：O（n * log(n)）, 平均：O（n * log(n)）
 * 空间复杂度  O（1）
 * 不稳定
 */
public class HeapSort<T extends Comparable<T>> implements Sort<T> {
  @Override
  public void sort(T[] arrays) {
    heapSort(arrays);
  }

  private void heapSort(T[] arrays) {
    buildHeap(arrays);
    int length = arrays.length;
    for (int i = 1; i <= length - 1; i++) {
      T tmp = arrays[0];
      arrays[0] = arrays[length - i];
      arrays[length - i] = tmp;
      updateHeap(arrays, 0, length - i);
    }
  }

  private void buildHeap(T[] arrays) {
    int length = arrays.length;
    for(int i = length / 2 - 1; i >= 0; i--) {
      updateHeap(arrays, i, length);
    }
  }

  private void updateHeap(T[] arrays, int index, int length) {
    int child = 2 * index + 1;
    if (child >= length)
      return;
    if (child + 1 < length && arrays[child + 1].compareTo(arrays[child]) > 0) {
      child++;
    }
    if (arrays[child].compareTo(arrays[index]) > 0) {
      T tmp = arrays[child];
      arrays[child] = arrays[index];
      arrays[index] = tmp;
      updateHeap(arrays, child, length);
    }
  }
}
