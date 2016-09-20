package tree.UnionFind;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxm on 2016/9/20.
 * 并查集：用于解决动态连通性的问题，如果涉及到连通路径需要用BFS或者DFS
 */
public abstract class AbstractUnionFind<T> {
  protected int count;  // 集合个数
  protected List<T> elements; // 元素
  protected int[] id;

  public AbstractUnionFind(int n) {
    count = n;
    elements = new ArrayList<>(n);
    id = new int[n];
    for (int i = 0; i < n; i++) {
      id[i] = i;
    }
  }

  /**
   * find the root of the element
   * @param element the element
   * @return the root
   */
  public T find(T element) {
    int index = elements.indexOf(element);
    return elements.get(find(index));
  }

  protected abstract int find(int element);

  /**
   * union two element
   * @param first the first element
   * @param second the second elemnt
   */
  public void union(T first, T second) {
    int p = elements.indexOf(first);
    if (p == -1) {
      elements.add(elements.size(), first);
      p = elements.size();
    }

    int q = elements.indexOf(second);
    if (q == -1) {
      elements.add(elements.size(), second);
      q = elements.size();
    }

    union(p, q);
  }

  public abstract void union(int first, int second);

  public int getCount() {
    return count;
  }
}
