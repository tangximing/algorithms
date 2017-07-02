package algorithms.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by tangxm on 2016/8/26.
 * 桶排序假设输入元素均匀而独立的分布在区间[1，100）上；
 * 桶排序的核心思想是，将[1，100）分为n个大小相同的子区间，上一个区间里的元素都比下一个区间里的元素小，然后对
 * 所有区间里的元素排序，最后顺序输出所有区间里的元素，达到对所有元素排序的目的。
 * 时间复杂度: O(N)
 */
public class BucketSort implements Sort<Integer> {
  private int count;
  private List<PriorityQueue<Integer>> buckets;

  public BucketSort(int count) {
    this.count = count;
    buckets = new ArrayList<>(count);
    for (int i = 0; i < count; i++) {
      buckets.add(new PriorityQueue<>());
    }
  }

  @Override
  public void sort(Integer[] arrays) {
    bucketSort(arrays);
  }

  private void bucketSort(Integer[] arrays) {
    for (Integer cur: arrays) {
      int index = cur / count;
      PriorityQueue<Integer> items = buckets.get(index);
      items.offer(cur);
      buckets.set(index, items);
    }

    int i = 0;
    for (PriorityQueue<Integer> treeSet: buckets) {
      while (!treeSet.isEmpty()) {
        arrays[i++] = treeSet.poll();
      }
    }
  }
}
