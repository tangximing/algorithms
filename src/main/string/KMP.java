package string;

/**
 * Created by tangxm on 2016/8/1.
 */
public class KMP {
  /** Generate the next array
   *  位置i的next值的计算：i之前字符串的前缀和后缀的最大长度
   * */
  public int[] getNext(String pattern) {
    int len = pattern.length();
    int[] next = new int[len];
    next[0] = -1;

    int k = -1;
    int j = 0;
    while (j < len - 1) {
      if (k == -1 || pattern.charAt(j) == pattern.charAt(k)) {
        k++;
        j++;
        next[j] = k;
      } else {
        k = next[k];
      }
    }

    return next;
  }

  public int kmp(String str, String pattern) {
    if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0)
      return -1;
    int[] next = getNext(pattern);
    int i = 0, j = 0, m = str.length(), n = pattern.length();
    while (i < m && j < n) {
      if (j == -1 || str.charAt(i) == pattern.charAt(j)) {
        i++;
        j++;
      } else {
        j = next[j];
      }
    }

    if (j == n) {
      return i - j;
    } else {
      return  -1;
    }
  }
}
