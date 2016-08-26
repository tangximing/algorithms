package array;

/**
 * Created by tangxm on 2016/8/25.
 * 1. 第K大的数 (爱奇艺)
 */
public class ArrayQA {
  /**
   * 第K大的数
   * @param arrays 无序数组
   * @param k k
   * @return 第k大的数
   */
  public int getK(int[] arrays, int k) {
    if (arrays == null || arrays.length == 0 || k > arrays.length)
      return -1;
    return getK(arrays, 0, arrays.length - 1, k);
  }
  private int getK(int[] arrays, int start, int end, int k) {
    if (start > end)
      return -1;
    int left = start, right = end;
    int target = arrays[left];
    while (left < right) {
      while (left < right && arrays[right] >= target) right--;
      arrays[left] = arrays[right];
      while (left < right && arrays[left] <= target) left++;
      arrays[right] = arrays[left];
    }
    arrays[left] = target;
    if (left == k - 1) {
      return arrays[left];
    } else if (left < k - 1) {
      // 注意不是在右边找k - left - 1大的数， 因为是按照下标来判断的
      // return getK(arrays, left + 1, end, k - left - 1);
      return getK(arrays, left + 1, end, k);
    } else {
      return getK(arrays, start, left - 1, k);
    }
  }
}
