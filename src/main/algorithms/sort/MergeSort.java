package algorithms.sort;

/**
 * Created by tangxm on 2016/7/27.
 * 主要思想 将原数组分成两数组，分别排序，最后将排好序的两数组合并
 * 时间复杂度  最好：O（n * log(n)）, 最坏：O（n * log(n)）, 平均：O（n * log(n)）
 * 空间复杂度  O（n）
 * 稳定
 */
public class MergeSort<T extends Comparable<T>> implements Sort<T> {
  @Override
  public void sort(T[] arrays) {
    mergeSort(arrays, 0, arrays.length - 1);
  }

  private void mergeSort(T[] arrays, int low, int high) {
    if (low < high) {
      int mid = low + ((high - low) >> 2);
      mergeSort(arrays, low, mid);
      mergeSort(arrays, mid + 1, high);
      merge(arrays, low, mid, high);
    }
  }

  private void merge(T[] arrays, int start, int mid, int end) {
    T[] tmp = arrays.clone();
    int i = start, j = mid + 1, k = start;
    while (i <= mid && j <= end) {
      if (arrays[i].compareTo(arrays[j]) <= 0) {
        tmp[k++] = arrays[i++];
      } else {
        tmp[k++] = arrays[j++];
      }
    }
    while (i <= mid) {
      tmp[k++] = arrays[i++];
    }
    while (j <= end) {
      tmp[k++] = arrays[j++];
    }

    for(i = start; i <= end; i++) {
      arrays[i] = tmp[i];
    }
  }
}
