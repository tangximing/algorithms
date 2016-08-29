package array;

/**
 * Created by tangxm on 2016/8/25.
 * 1. 第K大的数 (爱奇艺)
 * 2. 判断用二维数组表示的砖块是否漏水 （远景能源）
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

  /**
   * 2. 判断用二维数组表示的砖块是否漏水
   */
  private boolean[][] visited;
  public boolean isLeak(int[][] arrays) {
    int row = arrays.length;
    int col = arrays[0].length;
    visited = new boolean[row][col];
    for (int i = 0; i < col; i++) {
      visited[0][i] = true;
      if(dfs(arrays, 0, i, row, col)) {
        return true;
      } else {
        visited[0][i] = false;
      }
    }

    return false;
  }
  private boolean dfs(int[][] arrays, int i, int j, int row, int col) {
    if (i == row - 1) {
      return true;
    }

    if (j - 1 >= 0 && arrays[i][j - 1] == 0 && !visited[i][j - 1]) {
      visited[i][j - 1] = true;
      if(dfs(arrays, i, j - 1, row, col)) {
        return true;
      } else {
        visited[i][j - 1] = false;
      }
    }
    if (j + 1 < col && arrays[i][j + 1] == 0 && !visited[i][j + 1]) {
      visited[i][j + 1] = true;
      if(dfs(arrays, i, j + 1, row, col)) {
        return true;
      } else {
        visited[i][j + 1] = false;
      }
    }
    if (i + 1 < row && arrays[i + 1][j] == 0 && !visited[i + 1][j]) {
      visited[i + 1][j] = true;
      if(dfs(arrays, i + 1, j, row, col)) {
        return true;
      } else {
        visited[i + 1][j] = false;
      }
    }
    return false;
  }
}
