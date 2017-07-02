package algorithms.sort;

/**
 * Created by tangxm on 2016/7/27.
 */
public class ShellSort<T extends Comparable<T>> implements Sort<T> {
  @Override
  public void sort(T[] arrays) {
    int length = arrays.length;
    for (int gap = length / 2; gap > 0; gap /= 2) {
      for (int i = 0; i < gap; i++) {
        for (int j = i + gap; j < length; j += gap) {
          T target = arrays[j];
          int k = j - gap;
          while (k >= 0 && arrays[k].compareTo(target) > 0) {
            arrays[k + gap] = arrays[k];
            k -= gap;
          }
          arrays[k + gap] = target;
        }
      }
    }
  }
}
