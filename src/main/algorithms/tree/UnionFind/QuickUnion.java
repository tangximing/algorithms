package algorithms.tree.UnionFind;

/**
 * Created by tangxm on 2016/9/20.
 * 优点: 合并快
 * 缺点：查找慢，需要追溯到根节点才能查找到自己的组号
 */
public class QuickUnion<T> extends AbstractUnionFind<T> {

  public QuickUnion(int n) {
    super(n);
  }

  @Override
  protected int find(int element) {
    while (element != id[element]) {  // 如果合并顺序不合适，树的结构会退化成线性结构
      element = id[element];
    }
    return element;
  }

  @Override
  public void union(int first, int second) {
    int pRoot = find(first);
    int qRoot = find(second);
    if (pRoot == qRoot) {
      return;
    }

    id[pRoot] = qRoot; // 没有考虑树的规模
    count--;
  }
}
